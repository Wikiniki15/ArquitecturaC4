package com.consultavehiculo.service;

import com.consultavehiculo.dto.VehiculoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
@RequiredArgsConstructor
public class VehiculoService {
    private final WebClient webClient = WebClient.builder()
            .baseUrl("https://srienlinea.sri.gob.ec")
            .build();

    @Value("${vehiculo.api-url}")
    private String endpoint;

    public VehiculoDTO obtenerPorPlaca(String placa) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/sri-matriculacion-vehicular-recaudacion-servicio-internet/rest/BaseVehiculo/obtenerPorNumeroPlacaOPorNumeroCampvOPorNumeroCpn")
                        .queryParam("numeroPlacaCampvCpn", placa)
                        .build())
                .retrieve()
                .bodyToMono(VehiculoDTO.class)
                .block();
    }
}