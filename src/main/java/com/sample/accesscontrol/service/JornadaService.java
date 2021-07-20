package com.sample.accesscontrol.service;

import com.sample.accesscontrol.dto.MessageResponseDTO;
import com.sample.accesscontrol.dto.request.JornadaDTO;
import com.sample.accesscontrol.entity.Funcionario;
import com.sample.accesscontrol.entity.Jornada;
import com.sample.accesscontrol.mapper.JornadaMapper;
import com.sample.accesscontrol.repository.FuncRepository;
import com.sample.accesscontrol.repository.JornadaRepository;
import com.sample.accesscontrol.utils.DataHora;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JornadaService extends CommonService {
    
    private JornadaMapper jornadaMapper = JornadaMapper.INSTANCE;

    private JornadaRepository jornadaRepository;
    private FuncRepository funcRepository;
    
    @Autowired
    public JornadaService(JornadaRepository jornadaRepository, FuncRepository funcRepository) {
        this.jornadaRepository = jornadaRepository;
        this.funcRepository = funcRepository;
    }

    // PUT
    public MessageResponseDTO saveJornada(Long id) {
        Jornada jornada = new Jornada();
        JornadaDTO jornadaDTO = new JornadaDTO();
        jornadaDTO.setIdFunc(id);
        jornadaDTO.setDiaTrabalho(DataHora.getDia());
        // Verifica se já existe registro com campo horaInicio
        JornadaDTO exit = verificaSaida(jornadaDTO);
        if (exit == jornadaDTO) {
            jornada = jornadaMapper.toModel(setEntrada(jornadaDTO));
        } else {
            jornadaDTO = setSaida(jornadaDTO);
            jornada = jornadaMapper.toModel(jornadaDTO);
            jornada.setHoraInicio(exit.getHoraInicio());
            // Evita duplicação de registros
            jornada.setIdJorn(exit.getIdJorn());
        }
        jornada.setFunc(findFuncById(jornadaDTO.getIdFunc()));
        jornadaRepository.save(jornada);
        return super.criaMessageResponse(msgSucesso(jornadaDTO));
    }

    private Funcionario findFuncById(Long idFunc) {
        return funcRepository.getById(idFunc);
    }

    private JornadaDTO setEntrada(JornadaDTO jornadaDTO) {
        jornadaDTO.setHoraInicio(DataHora.getHorario());
        return jornadaDTO;
    }

    private JornadaDTO setSaida(JornadaDTO jornadaDTO) {
        jornadaDTO.setHoraFim(DataHora.getHorario());
        return jornadaDTO;
    }

    private JornadaDTO verificaSaida(JornadaDTO jornadaDTO) {
        List<Jornada> todasJornadas = jornadaRepository.findAll();
        for (Jornada j : todasJornadas) {
            // Se já existe um DTO com data de entrada, mas sem data de saída, retorna ele
            if (j.getFunc().getIdFunc() == jornadaDTO.getIdFunc() && j.getHoraFim() == null) {
                return jornadaMapper.toDto(j);
            }
        }
        return jornadaDTO;
    }

    // Composição da mensagem de resposta
    private String msgSucesso(JornadaDTO jornadaDTO) {
        String message, nomeFunc = findFuncById(jornadaDTO.getIdFunc()).getName();
        message = "Data: " + jornadaDTO.getDiaTrabalho() +
                  "\nFuncionário: " + nomeFunc;
        if (jornadaDTO.getHoraInicio() != null) message += "\nEntrada: " + jornadaDTO.getHoraInicio();
        if (jornadaDTO.getHoraFim() != null) message += "\nSaída: " + jornadaDTO.getHoraFim();
        return message;
    }
}
