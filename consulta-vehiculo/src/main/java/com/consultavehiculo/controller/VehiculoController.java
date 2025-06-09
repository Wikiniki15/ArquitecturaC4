package com.consultavehiculo.controller;

import com.consultavehiculo.dto.VehiculoDTO;
import com.consultavehiculo.service.VehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehiculo")
@RequiredArgsConstructor
public class VehiculoController {
    private final VehiculoService vehiculoService;

    @GetMapping("/{placa}")
    public ResponseEntity<VehiculoDTO> consultarVehiculo(@PathVariable String placa) {
        VehiculoDTO datos = vehiculoService.obtenerPorPlaca(placa);
        return ResponseEntity.ok(datos);
    }
}
