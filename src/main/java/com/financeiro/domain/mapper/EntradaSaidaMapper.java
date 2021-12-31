package com.financeiro.domain.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.financeiro.domain.dto.EntradaSaidaMensalDTO;
import com.financeiro.domain.model.EntradaSaida;

@Component
public class EntradaSaidaMapper {
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public EntradaSaidaMensalDTO entradaSaidaToDto (EntradaSaida entradaSaida) {
		return modelMapper.map(entradaSaida, EntradaSaidaMensalDTO.class);
	}

}
