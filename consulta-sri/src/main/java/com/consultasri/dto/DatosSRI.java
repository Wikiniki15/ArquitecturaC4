package com.consultasri.dto;

import lombok.Data;
import java.util.List;

@Data
public class DatosSRI {
    private String numeroRuc;
    private String razonSocial;
    private String estadoContribuyenteRuc;
    private String actividadEconomicaPrincipal;
    private String tipoContribuyente;
    private String regimen;
    private String categoria;
    private String obligadoLlevarContabilidad;
    private String agenteRetencion;
    private String contribuyenteEspecial;
    private InformacionFechasContribuyente informacionFechasContribuyente;
    private List<RepresentanteLegal> representantesLegales;
    private String motivoCancelacionSuspension;
    private String contribuyenteFantasma;
    private String transaccionesInexistente;
}
