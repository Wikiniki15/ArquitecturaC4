package com.consultaant.service;

import com.consultaant.dto.DatosLicenciaDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class AntService {

    @Cacheable(value = "puntosLicencia", key = "#cedula")
    public DatosLicenciaDTO obtenerPuntosLicencia(String cedula, String placa) {
        try {
            String url = "https://consultaweb.ant.gob.ec/PortalWEB/paginas/clientes/clp_grid_citaciones.jsp?ps_tipo_identificacion=CED&ps_identificacion="
                    + cedula + "&ps_placa=" + placa;

            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0")
                    .timeout(10000)
                    .get();

            Elements tabla = doc.select("table");
            if (!tabla.isEmpty()) {
                // Aquí deberías parsear valores reales desde el HTML
                return DatosLicenciaDTO.builder()
                        .puntos(24)
                        .estadoLicencia("ACTIVA")
                        .observaciones("Sin observaciones")
                        .build();
            } else {
                return DatosLicenciaDTO.builder()
                        .puntos(0)
                        .estadoLicencia("No disponible")
                        .observaciones("No se encontraron datos")
                        .build();
            }

        } catch (Exception e) {
            return DatosLicenciaDTO.builder()
                    .puntos(0)
                    .estadoLicencia("ERROR")
                    .observaciones("Error al consultar ANT: " + e.getMessage())
                    .build();
        }
    }
}