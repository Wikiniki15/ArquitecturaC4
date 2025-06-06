package com.consultaciudadano.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.consultaciudadano.service.ConsultaService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;

    @GetMapping("/sri/contribuyente/{ruc}")
    public ResponseEntity<?> verificarContribuyente(@PathVariable String ruc) {
        return ResponseEntity.ok(consultaService.verificarContribuyente(ruc));
    }

    @GetMapping("/vehiculo/{placa}")
    public ResponseEntity<?> consultarVehiculo(@PathVariable String placa) {
        return ResponseEntity.ok(consultaService.consultarVehiculo(placa));
    }

    @GetMapping("/ant/puntos/{cedula}/{placa}")
    public ResponseEntity<?> consultarPuntos(@PathVariable String cedula, @PathVariable String placa) {
        return ResponseEntity.ok(consultaService.consultarPuntosLicencia(cedula, placa));
    }
}
