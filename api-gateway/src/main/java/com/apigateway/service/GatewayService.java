package com.apigateway.service;

import com.apigateway.dto.RespuestaDTO;
import com.consultaant.dto.DatosLicenciaDTO;
import com.consultasri.dto.DatosSRI;
import com.consultasri.dto.InformacionFechasContribuyente;
import com.consultasri.dto.RepresentanteLegal;
import com.consultavehiculo.dto.VehiculoDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class GatewayService {

    private final RestTemplate restTemplate;

    @Value("${servicios.sri-url}")
    private String sriUrl;

    @Value("${servicios.vehiculo-url}")
    private String vehiculoUrl;

    @Value("${servicios.ant-url}")
    private String antUrl;

    public RespuestaDTO consultarTodo(String cedula, String ruc, String placa) {

        DatosSRI datosSRI = null;
        InformacionFechasContribuyente informacionFechas = null;
        RepresentanteLegal representanteLegal = null;
        VehiculoDTO datosVehiculo = null;
        DatosLicenciaDTO datosANT = null;

        // Microservicio SRI
        try {
            datosSRI = restTemplate.getForObject(sriUrl + "/" + ruc, DatosSRI.class);
        } catch (RestClientException e) {
            log.warn("Error consultando DatosSRI para RUC {}: {}", ruc, e.getMessage());
        }

        try {
            informacionFechas = restTemplate.getForObject(sriUrl + "/" + ruc + "/fechas", InformacionFechasContribuyente.class);
        } catch (RestClientException e) {
            log.warn("Error consultando InformacionFechasContribuyente para RUC {}: {}", ruc, e.getMessage());
        }

        try {
            representanteLegal = restTemplate.getForObject(sriUrl + "/" + ruc + "/representante", RepresentanteLegal.class);
        } catch (RestClientException e) {
            log.warn("Error consultando RepresentanteLegal para RUC {}: {}", ruc, e.getMessage());
        }

        // Microservicio Vehículo
        try {
            datosVehiculo = restTemplate.getForObject(vehiculoUrl + "/" + placa, VehiculoDTO.class);
        } catch (RestClientException e) {
            log.warn("Error consultando VehiculoDTO para placa {}: {}", placa, e.getMessage());
        }

        // Microservicio ANT
        try {
            datosANT = restTemplate.getForObject(antUrl + "/" + cedula, DatosLicenciaDTO.class);
        } catch (RestClientException e) {
            log.warn("Error consultando DatosLicenciaDTO para cédula {}: {}", cedula, e.getMessage());
        }

        return RespuestaDTO.builder()
                .datosSRI(datosSRI)
                .informacionFechas(informacionFechas)
                .representanteLegal(representanteLegal)
                .datosVehiculo(datosVehiculo)
                .datosANT(datosANT)
                .build();
    }
}