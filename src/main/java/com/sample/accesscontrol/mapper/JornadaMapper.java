package com.sample.accesscontrol.mapper;

import com.sample.accesscontrol.dto.request.JornadaDTO;
import com.sample.accesscontrol.entity.Jornada;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JornadaMapper {
    
    JornadaMapper INSTANCE = Mappers.getMapper(JornadaMapper.class);

    @Mapping(target = "diaTrabalho", source = "diaTrabalho", dateFormat = "dd-MM-yyyy")
    Jornada toModel(JornadaDTO jornadaDTO);

    JornadaDTO toDto(Jornada jornada);
}
