package com.consultavehiculo.dto;

import lombok.Data;

@Data
public class VehiculoDTO {
    private Integer codigoVehiculo;
    private String numeroPlaca;
    private String numeroCamvCpn;
    private String colorVehiculo1;
    private String colorVehiculo2;
    private String cilindraje;
    private String nombreClase;
    private String descripcionMarca;
    private String descripcionModelo;
    private Integer anioAuto;
    private String descripcionPais;
    private String mensajeMotivoAuto;
    private Boolean aplicaCuota;
    private String fechaUltimaMatricula;
    private String fechaCaducidadMatricula;
    private String fechaCompraRegistro;
    private String fechaRevision;
    private String descripcionCanton;
    private String descripcionServicio;
    private Integer ultimoAnioPagado;
    private String prohibidoEnajenar;
    private String observacion;
    private String estadoExoneracion;
}