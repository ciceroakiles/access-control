package com.sample.accesscontrol.controller;

import com.sample.accesscontrol.dto.MessageResponseDTO;
import com.sample.accesscontrol.dto.request.FuncionarioDTO;
import com.sample.accesscontrol.service.FuncService;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/funcionario")
public class FuncController {
    
    private FuncService funcService;

    @Autowired
    public FuncController(FuncService funcService) {
        this.funcService = funcService;
    }

    // GET
    @GetMapping("/{id}")
    public FuncionarioDTO findById(@PathVariable Long id) throws NoSuchElementException {
        return funcService.findById(id);
    }

    // POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO criaPessoa(@RequestBody FuncionarioDTO funcDTO) {
        return funcService.criaFunc(funcDTO);
    }

    // PUT
    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody FuncionarioDTO funcDTO) throws NoSuchElementException {
        return funcService.updateById(id, funcDTO);
    }

    // DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws NoSuchElementException {
        funcService.deleteById(id);
    }

    // List
    @GetMapping
    public List<FuncionarioDTO> listAll() {
        return funcService.listAll();
    }
}
