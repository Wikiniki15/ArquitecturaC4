package com.consultaant.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DatosLicenciaDTO {
    private int puntos;
    private String estadoLicencia;
    private String observaciones;
}