package com.consultaciudadano.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.Map;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final WebClient webClient = WebClient.create();

    public Map<String, Object> verificarContribuyente(String ruc) {
        Map<String, Object> datos = new HashMap<>();
        datos.put("ruc", ruc);
        datos.put("contribuyente", true);
        datos.put("nombre", "Juan Pérez");
        datos.put("tipo", "Persona Natural");
        return datos;
    }

    public Map<String, Object> consultarVehiculo(String placa) {
        Map<String, Object> datos = new HashMap<>();
        datos.put("placa", placa);
        datos.put("marca", "Kia");
        datos.put("modelo", "Rio");
        datos.put("anio", 2020);
        return datos;
    }

    @Cacheable(value = "puntosLicencia", key = "#cedula")
    public Map<String, Object> consultarPuntosLicencia(String cedula, String placa) {
        Map<String, Object> datos = new HashMap<>();
        datos.put("cedula", cedula);
        datos.put("placa", placa);
        datos.put("puntos", 24);
        datos.put("estado", "VIGENTE");
        return datos;
    }

}
