package com.apigateway.dto;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaDTO {
    private DatosSRI datosSRI;
    private DatosVehiculo datosVehiculo;
    private DatosLicencia datosLicencia;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DatosSRI {
        private String nombre;
        private String tipoContribuyente;
        private String estado;
        private String actividadEconomica;
        private boolean esPersonaNatural;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DatosVehiculo {
        private String placa;
        private String marca;
        private String modelo;
        private String anio;
        private String tipo;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DatosLicencia {
        private int puntos;
        private String estadoLicencia;
        private String observaciones;
    }
}