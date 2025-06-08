package com.consultasri.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SriService {

    @Cacheable(value = "verificarContribuyente", key = "#ruc")
    public Map<String, Object> verificarContribuyente(String ruc) {
        Map<String, Object> datos = new HashMap<>();
        try {
            // Aquí va la lógica real con WebClient a la API del SRI.
            // Simulación:
            datos.put("ruc", ruc);
            datos.put("contribuyente", true);
            datos.put("nombre", "Juan Pérez");
            datos.put("tipo", "Persona Natural");
        } catch (Exception e) {
            datos.put("error", "No se pudo consultar el SRI: " + e.getMessage());
        }
        return datos;
    }
}