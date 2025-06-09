package com.consultasri.controller;

import com.consultasri.dto.DatosSRI;
import com.consultasri.service.SriService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sri")
@RequiredArgsConstructor
public class SriController {

    private final SriService sriService;

    @GetMapping("/contribuyente/{ruc}")
    public ResponseEntity<?> obtenerDatosContribuyente(@PathVariable String ruc) {
        DatosSRI datos = sriService.consultarInformacionContribuyente(ruc);

        if (datos == null) {
            return ResponseEntity.badRequest().body("No se encontró un contribuyente válido o no es persona natural.");
        }

        return ResponseEntity.ok(datos);
    }
}