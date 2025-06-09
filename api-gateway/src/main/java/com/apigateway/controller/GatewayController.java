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
    public ResponseEntity<RespuestaDTO> consultar(
            @RequestParam String cedula,
            @RequestParam String ruc,
            @RequestParam String placa
    ) {
        RespuestaDTO respuesta = gatewayService.consultarTodo(cedula, ruc, placa);
        return ResponseEntity.ok(respuesta);
    }
}