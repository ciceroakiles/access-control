package com.sample.accesscontrol.service;

import com.sample.accesscontrol.dto.MessageResponseDTO;
import com.sample.accesscontrol.dto.request.FuncionarioDTO;
import com.sample.accesscontrol.entity.Funcionario;
import com.sample.accesscontrol.mapper.FuncMapper;
import com.sample.accesscontrol.repository.FuncRepository;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncService extends CommonService {
    
    private FuncMapper funcMapper = FuncMapper.INSTANCE;

    private FuncRepository funcRepository;

    @Autowired
    public FuncService(FuncRepository funcRepository) {
        this.funcRepository = funcRepository;
    }

    // GET
    public FuncionarioDTO findById(Long id) throws NoSuchElementException {
        return funcMapper.toDto(
            funcRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Funcionário não encontrado"))
        );
    }

    // POST
    public MessageResponseDTO criaFunc(FuncionarioDTO funcDTO) {
        Funcionario beforeSave = funcMapper.toModel(funcDTO);
        Funcionario salvo = funcRepository.save(beforeSave);
        return criaMessageResponse("Objeto <Funcionario> criado (ID " + salvo.getIdFunc() + ")");
    }

    // PUT
    public MessageResponseDTO updateById(Long id, FuncionarioDTO funcDTO) throws NoSuchElementException {
        verificaFuncionario(id);
        Funcionario updated = funcMapper.toModel(funcDTO);
        Funcionario salvo = funcRepository.save(updated);
        return criaMessageResponse("Objeto <Funcionario> atualizado (ID " + salvo.getIdFunc() + ")");
    }

    // DELETE
    public void deleteById(Long id) throws NoSuchElementException {
        verificaFuncionario(id);
        funcRepository.deleteById(id);
    }

    public List<FuncionarioDTO> listAll() {
        List<Funcionario> todosFunc = funcRepository.findAll();
        return todosFunc
            .stream()
            .map(funcMapper::toDto)
            .collect(Collectors.toList());
    }

    private Funcionario verificaFuncionario(Long id) throws NoSuchElementException {
        Funcionario funcExiste = funcRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException());
        return funcExiste;
    }
}
