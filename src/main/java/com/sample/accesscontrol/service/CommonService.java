package com.sample.accesscontrol.service;

import com.sample.accesscontrol.dto.MessageResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class CommonService {

    protected MessageResponseDTO criaMessageResponse(String msg) {
        return MessageResponseDTO.builder().message(msg).build();
    }
}
