package com.sample.accesscontrol.repository;

import com.sample.accesscontrol.entity.Jornada;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JornadaRepository extends JpaRepository<Jornada, Long> {
    
    Optional<Jornada> findByDiaTrabalho(String diaTrabalho);
}
