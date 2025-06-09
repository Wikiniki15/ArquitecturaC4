package com.apigateway.dto;
import com.consultaant.dto.DatosLicenciaDTO;
import com.consultasri.dto.DatosSRI;
import com.consultasri.dto.InformacionFechasContribuyente;
import com.consultasri.dto.RepresentanteLegal;
import com.consultavehiculo.dto.VehiculoDTO;
import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaDTO {

    // Datos del SRI
    private DatosSRI datosSRI;
    private InformacionFechasContribuyente informacionFechas;
    private RepresentanteLegal representanteLegal;

    // Datos del vehículo
    private VehiculoDTO datosVehiculo;

    // Datos de la licencia de la ANT
    private DatosLicenciaDTO datosANT;
}