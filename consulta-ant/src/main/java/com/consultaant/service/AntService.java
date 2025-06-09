package com.consultaant.service;

import com.consultaant.dto.DatosLicenciaDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class AntService {

    @Cacheable("licencia")
    public DatosLicenciaDTO obtenerPuntosLicencia(String cedula) {
        String url = "https://consultaweb.ant.gob.ec/PortalWEB/paginas/clientes/clp_grid_citaciones.jsp?ps_tipo_identificacion=CED&ps_identificacion=" + cedula + "&ps_placa=";
        try {
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0")
                    .timeout(10_000)
                    .get();

            Elements elementos = doc.select("td:contains(PUNTOS)").next();
            if (!elementos.isEmpty()) {
                String puntosStr = elementos.first().text().trim();
                int puntos = Integer.parseInt(puntosStr);
                return new DatosLicenciaDTO(cedula, puntos);
            }
        } catch (IOException | NumberFormatException e) {
            // log or handle error
        }
        return new DatosLicenciaDTO(cedula, -1); // -1 indica error o no encontrado
    }
}