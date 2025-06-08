package com.consultaciudadano.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ConsultaService {

    @Cacheable("verificarContribuyente")
    public Map<String, Object> verificarContribuyente(String ruc) {
        Map<String, Object> datos = new HashMap<>();
        datos.put("ruc", ruc);
        datos.put("contribuyente", true);
        datos.put("nombre", "Juan Pérez");
        datos.put("tipo", "Persona Natural");
        return datos;
    }

    @Cacheable("consultarVehiculo")
    public Map<String, Object> consultarVehiculo(String placa) {
        Map<String, Object> datos = new HashMap<>();
        datos.put("placa", placa);
        datos.put("marca", "Kia");
        datos.put("modelo", "Rio");
        datos.put("anio", 2020);
        return datos;
    }

    @Cacheable("consultarPuntosLicencia")
    public Map<String, Object> consultarPuntosLicencia(String cedula, String placa) {
        Map<String, Object> datos = new HashMap<>();
        datos.put("puntos", 24);
        datos.put("cedula", cedula);
        datos.put("placa", placa);
        return datos;
    }

}
