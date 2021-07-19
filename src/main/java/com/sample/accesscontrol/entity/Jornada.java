package com.sample.accesscontrol.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Funcionario func;

    private LocalDate diaTrabalho;

    private String horaInicio;

    private String horaFim;
}
