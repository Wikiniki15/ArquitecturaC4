package com.apigateway.service;

import com.apigateway.dto.RespuestaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/* GatewayService que usa programación reactiva con Mono */
@Service
@RequiredArgsConstructor
public class GatewayService {

    private final WebClient.Builder webClientBuilder;

    public Mono<RespuestaDTO> obtenerInformacion(String cedula, String placa) {
        WebClient webClient = webClientBuilder.build();

        Mono<RespuestaDTO.DatosSRI> sriMono = webClient.get()
                .uri("http://localhost:8081/sri/contribuyente/{ruc}", cedula)
                .retrieve()
                .bodyToMono(RespuestaDTO.DatosSRI.class);

        Mono<RespuestaDTO.DatosVehiculo> vehiculoMono = webClient.get()
                .uri("http://localhost:8082/vehiculo/{placa}", placa)
                .retrieve()
                .bodyToMono(RespuestaDTO.DatosVehiculo.class);

        Mono<RespuestaDTO.DatosLicencia> licenciaMono = webClient.get()
                .uri("http://localhost:8083/ant/puntos?cedula={cedula}&placa={placa}", cedula, placa)
                .retrieve()
                .bodyToMono(RespuestaDTO.DatosLicencia.class);

        return Mono.zip(sriMono, vehiculoMono, licenciaMono)
                .map(tuple -> RespuestaDTO.builder()
                        .datosSRI(tuple.getT1())
                        .datosVehiculo(tuple.getT2())
                        .datosLicencia(tuple.getT3())
                        .build());
    }
}