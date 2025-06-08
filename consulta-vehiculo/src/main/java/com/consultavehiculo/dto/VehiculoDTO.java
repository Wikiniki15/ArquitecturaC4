package com.consultavehiculo.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoDTO {
    private String placa;
    private String marca;
    private String modelo;
    private String anio;
    private String tipo;
}