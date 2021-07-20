package com.sample.accesscontrol.controller;

import com.sample.accesscontrol.dto.MessageResponseDTO;
import com.sample.accesscontrol.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/jornada")
public class JornadaController {
    
    private JornadaService jornadaService;

    @Autowired
    public JornadaController(JornadaService jornadaService) {
        this.jornadaService = jornadaService;
    }

    // PUT (id do funcionário)
    @PutMapping("/{id}")
    public MessageResponseDTO criaJornada(@PathVariable Long id){
        return jornadaService.saveJornada(id);
    }
}
