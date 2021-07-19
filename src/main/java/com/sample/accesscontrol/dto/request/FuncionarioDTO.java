package com.sample.accesscontrol.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDTO {
    
    private Long idFunc;

    private String name;

    private String dataNasc;

    private Long idCargo;
}
