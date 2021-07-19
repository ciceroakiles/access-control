package com.sample.accesscontrol.mapper;

import com.sample.accesscontrol.dto.request.JornadaDTO;
import com.sample.accesscontrol.entity.Jornada;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JornadaMapper {
    
    JornadaMapper INSTANCE = Mappers.getMapper(JornadaMapper.class);

    @Mapping(source = "diaTrabalho", target = "diaTrabalho", dateFormat = "dd-MM-yyyy")
    @Mapping(source = "idFunc", target = "func.idFunc")
    Jornada toModel(JornadaDTO jornadaDTO);

    @Mapping(source = "func.idFunc", target = "idFunc")
    JornadaDTO toDto(Jornada jornada);
}
