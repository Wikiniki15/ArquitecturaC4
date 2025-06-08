package com.consultavehiculo.service;

import com.consultavehiculo.dto.VehiculoDTO;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class VehiculoService {

    @Cacheable(value = "vehiculos", key = "#placa")
    public VehiculoDTO obtenerVehiculoPorPlaca(String placa) {
        // Simulación de datos reales
        return VehiculoDTO.builder()
                .placa(placa)
                .marca("Toyota")
                .modelo("Corolla")
                .anio("2022")
                .tipo("Sedán")
                .build();
    }
}