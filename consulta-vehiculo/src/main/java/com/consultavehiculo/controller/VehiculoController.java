package com.consultavehiculo.controller;

import com.consultavehiculo.service.VehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehiculo")
@RequiredArgsConstructor
public class VehiculoController {

    private final VehiculoService vehiculoService;

    @GetMapping("/{placa}")
    public ResponseEntity<?> obtenerVehiculo(@PathVariable String placa) {
        return ResponseEntity.ok(vehiculoService.obtenerVehiculoPorPlaca(placa));
    }
}