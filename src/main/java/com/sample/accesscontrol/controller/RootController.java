package com.sample.accesscontrol.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RootController {
    @GetMapping
    public String msg() {
        return "Whoops! Aqui é a raiz. Tente outro caminho.";
    }
}
