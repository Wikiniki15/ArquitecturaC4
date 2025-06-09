package com.consultasri.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DatosSRICompletoDTO {
    private DatosSRI datosSRI;
    private InformacionFechasContribuyente informacionFechas;
    private RepresentanteLegal representanteLegal;
}