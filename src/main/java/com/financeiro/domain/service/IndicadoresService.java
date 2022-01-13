package com.financeiro.domain.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financeiro.domain.model.Parcela;
import com.financeiro.domain.repository.ParcelaRepository;
import com.financeiro.util.Utilitarios;

@Service
public class IndicadoresService {
	
	@Autowired
	private ParcelaRepository repo;
	
	public void indicadores() {
		List<Parcela> parcelas;
		LocalDate hoje = LocalDate.now();
		parcelas = repo.findByDataVencimentoBetween(Utilitarios.primeiroDiaMes(hoje), Utilitarios.ultimoDiaMes(hoje));
	}
	

}
