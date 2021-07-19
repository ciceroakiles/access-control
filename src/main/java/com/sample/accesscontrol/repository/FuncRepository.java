package com.sample.accesscontrol.repository;

import com.sample.accesscontrol.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncRepository extends JpaRepository<Funcionario, Long> {
    
}
