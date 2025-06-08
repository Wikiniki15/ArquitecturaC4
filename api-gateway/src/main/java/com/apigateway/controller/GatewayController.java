package com.apigateway.controller;

import com.apigateway.dto.RespuestaDTO;
import com.apigateway.service.GatewayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/* GatewayController que usa programación reactiva con Mono */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class GatewayController {

    private final GatewayService gatewayService;

    @GetMapping("/consulta")
    public Mono<ResponseEntity<RespuestaDTO>> obtenerDatos(@RequestParam String cedula, @RequestParam String placa) {
        return gatewayService.obtenerInformacion(cedula, placa)
                .map(ResponseEntity::ok);
    }
}