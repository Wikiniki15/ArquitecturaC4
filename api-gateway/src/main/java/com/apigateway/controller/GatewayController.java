package com.apigateway.controller;

import com.apigateway.dto.RespuestaDTO;
import com.apigateway.service.GatewayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class GatewayController {

    private final GatewayService gatewayService;

    @GetMapping("/consulta")
    public ResponseEntity<RespuestaDTO> obtenerDatos(@RequestParam String cedula, @RequestParam String placa) {
        return ResponseEntity.ok(gatewayService.obtenerInformacion(cedula, placa));
    }
}