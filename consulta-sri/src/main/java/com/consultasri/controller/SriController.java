package com.consultasri.controller;

import com.consultasri.service.SriService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sri")
@RequiredArgsConstructor
public class SriController {

    private final SriService sriService;

    @GetMapping("/contribuyente/{ruc}")
    public ResponseEntity<?> verificarContribuyente(@PathVariable String ruc) {
        return ResponseEntity.ok(sriService.verificarContribuyente(ruc));
    }
}