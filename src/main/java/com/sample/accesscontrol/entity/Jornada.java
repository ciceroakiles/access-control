package com.sample.accesscontrol.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Jornada {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJorn;

    @OneToOne
    private Funcionario Func;

    private LocalDate diaTrabalho;

    private String horaInicio;

    private String horaFim;
}
