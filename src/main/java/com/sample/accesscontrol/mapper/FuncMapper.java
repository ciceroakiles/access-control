package com.sample.accesscontrol.mapper;

import com.sample.accesscontrol.dto.request.FuncionarioDTO;
import com.sample.accesscontrol.entity.Funcionario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FuncMapper {

    FuncMapper INSTANCE = Mappers.getMapper(FuncMapper.class);

    @Mapping(source = "dataNasc", target = "dataNasc", dateFormat = "dd-MM-yyyy")
    @Mapping(source = "idCargo", target = "cargo.idCargo")
    Funcionario toModel(FuncionarioDTO funcionarioDTO);

    @Mapping(source = "cargo.idCargo", target = "idCargo")
    FuncionarioDTO toDto(Funcionario funcionario);
}
