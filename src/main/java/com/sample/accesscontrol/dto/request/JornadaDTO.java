package com.sample.accesscontrol.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JornadaDTO {
    
    private Long idJorn;

    private Long idFunc;

    private String diaTrabalho;

    private String horaInicio;

    private String horaFim;
}
