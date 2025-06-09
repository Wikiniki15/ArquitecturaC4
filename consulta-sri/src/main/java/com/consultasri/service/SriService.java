package com.consultasri.service;

import com.consultasri.dto.DatosSRI;
import com.consultasri.dto.DatosSRICompletoDTO;
import com.consultasri.dto.InformacionFechasContribuyente;
import com.consultasri.dto.RepresentanteLegal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SriService {

    private final WebClient webClient = WebClient.builder().build();

    public boolean verificarExistenciaRuc(String ruc) {
        return webClient.get()
                .uri("https://srienlinea.sri.gob.ec/sri-catastro-sujeto-servicio-internet/rest/ConsolidadoContribuyente/existePorNumeroRuc?numeroRuc=" + ruc)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }

    public DatosSRI obtenerDatosContribuyente(String ruc) {
        DatosSRI[] resultado = webClient.get()
                .uri("https://srienlinea.sri.gob.ec/sri-catastro-sujeto-servicio-internet/rest/ConsolidadoContribuyente/obtenerPorNumerosRuc?ruc=" + ruc)
                .retrieve()
                .bodyToMono(DatosSRI[].class)
                .block();

        return resultado != null && resultado.length > 0 ? resultado[0] : null;
    }

    public DatosSRI consultarInformacionContribuyente(String ruc) {
        if (!verificarExistenciaRuc(ruc)) return null;

        DatosSRI datos = obtenerDatosContribuyente(ruc);
        if (datos == null) return null;

        if (!"PERSONA NATURAL".equalsIgnoreCase(datos.getTipoContribuyente())) return null;

        return datos;
    }

    public InformacionFechasContribuyente obtenerFechasContribuyente(String ruc) {
        return webClient.get()
                .uri("https://srienlinea.sri.gob.ec/sri-catastro-sujeto-servicio-internet/rest/ConsolidadoContribuyente/obtenerFechasPorNumeroRuc?numeroRuc=" + ruc)
                .retrieve()
                .bodyToMono(InformacionFechasContribuyente.class)
                .block();
    }

    public RepresentanteLegal obtenerRepresentanteLegal(String ruc) {
        RepresentanteLegal[] resultado = webClient.get()
                .uri("https://srienlinea.sri.gob.ec/sri-catastro-sujeto-servicio-internet/rest/ConsolidadoContribuyente/obtenerRepresentantesLegalesPorNumeroRuc?numeroRuc=" + ruc)
                .retrieve()
                .bodyToMono(RepresentanteLegal[].class)
                .block();

        return resultado != null && resultado.length > 0 ? resultado[0] : null;
    }


    public DatosSRICompletoDTO obtenerDatosCompletos(String ruc) {
        DatosSRI datos = obtenerDatosContribuyente(ruc); // ya existente
        InformacionFechasContribuyente fechas = obtenerFechasContribuyente(ruc); // ya existente
        RepresentanteLegal representante = obtenerRepresentanteLegal(ruc); // ya existente

        return DatosSRICompletoDTO.builder()
                .datosSRI(datos)
                .informacionFechas(fechas)
                .representanteLegal(representante)
                .build();
    }
}