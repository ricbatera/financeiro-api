package com.financeiro.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financeiro.domain.model.Parcela;
import com.financeiro.domain.repository.ParcelaRepository;

@Service
public class IndicadoresService {
	
	@Autowired
	private ParcelaRepository repo;
	
	public void indicadores() {
		List<Parcela> parcelas = repo.findAll();
		
		
	}

}
