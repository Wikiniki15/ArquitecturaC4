package com.apigateway.service;

import com.apigateway.dto.RespuestaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class GatewayService {

    private final WebClient.Builder webClientBuilder;

    public RespuestaDTO obtenerInformacion(String cedula, String placa) {
        // Llamada al microservicio de SRI
        RespuestaDTO.DatosSRI sri = webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/sri/contribuyente/{ruc}", cedula)
                .retrieve()
                .bodyToMono(RespuestaDTO.DatosSRI.class)
                .block();

        // Llamada al microservicio de Vehículo
        RespuestaDTO.DatosVehiculo vehiculo = webClientBuilder.build()
                .get()
                .uri("http://localhost:8082/vehiculo/{placa}", placa)
                .retrieve()
                .bodyToMono(RespuestaDTO.DatosVehiculo.class)
                .block();

        // Llamada al microservicio de ANT
        RespuestaDTO.DatosLicencia licencia = webClientBuilder.build()
                .get()
                .uri("http://localhost:8083/ant/puntos?cedula={cedula}&placa={placa}", cedula, placa)
                .retrieve()
                .bodyToMono(RespuestaDTO.DatosLicencia.class)
                .block();

        return RespuestaDTO.builder()
                .datosSRI(sri)
                .datosVehiculo(vehiculo)
                .datosLicencia(licencia)
                .build();
    }
}