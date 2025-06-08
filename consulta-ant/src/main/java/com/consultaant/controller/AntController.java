package com.consultaant.controller;

import com.consultaant.dto.DatosLicenciaDTO;
import com.consultaant.service.AntService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ant")
@RequiredArgsConstructor
public class AntController {

    private final AntService antService;

    @GetMapping("/puntos")
    public ResponseEntity<DatosLicenciaDTO> consultarPuntosLicencia(
            @RequestParam String cedula,
            @RequestParam String placa) {
        return ResponseEntity.ok(antService.obtenerPuntosLicencia(cedula, placa));
    }
}