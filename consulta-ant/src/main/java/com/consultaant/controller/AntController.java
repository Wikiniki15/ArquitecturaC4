package com.consultaant.controller;

import com.consultaant.dto.DatosLicenciaDTO;
import com.consultaant.service.AntService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ant")
@RequiredArgsConstructor
public class AntController {
    private final AntService antService;

    @GetMapping("/puntos/{cedula}")
    public ResponseEntity<DatosLicenciaDTO> consultarPuntos(@PathVariable String cedula) {
        DatosLicenciaDTO datos = antService.obtenerPuntosLicencia(cedula);
        return ResponseEntity.ok(datos);
    }
}
