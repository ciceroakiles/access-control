package com.sample.accesscontrol.controller;

import com.sample.accesscontrol.dto.MessageResponseDTO;
import com.sample.accesscontrol.dto.request.JornadaDTO;
import com.sample.accesscontrol.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/jornada")
public class JornadaController {
    
    private JornadaService jornadaService;

    @Autowired
    public JornadaController(JornadaService jornadaService) {
        this.jornadaService = jornadaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createJornada(@RequestBody JornadaDTO jornadaDTO){
        return jornadaService.saveJornada(jornadaDTO);
    }
}
