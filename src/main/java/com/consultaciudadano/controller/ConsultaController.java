package com.consultaciudadano.controller;

import com.consultaciudadano.service.ConsultaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;

    // Endpoint para consultar si el RUC es contribuyente
    @GetMapping("/sri/contribuyente/{ruc}")
    public ResponseEntity<?> verificarContribuyente(@PathVariable String ruc) {
        return ResponseEntity.ok(consultaService.verificarContribuyente(ruc));
    }

    // Endpoint para consultar información del vehículo
    @GetMapping("/vehiculo/{placa}")
    public ResponseEntity<?> consultarVehiculo(@PathVariable String placa) {
        return ResponseEntity.ok(consultaService.consultarVehiculo(placa));
    }

    // Endpoint para consultar puntos de licencia (opcional, si lo tienes)
    @GetMapping("/ant/puntos/{cedula}/{placa}")
    public ResponseEntity<?> consultarPuntos(@PathVariable String cedula, @PathVariable String placa) {
        return ResponseEntity.ok(consultaService.consultarPuntosLicencia(cedula, placa));
    }

}
