package com.financeiro.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financeiro.domain.model.Funcionario;
import com.financeiro.domain.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository repo;
	
	public void novoFuncionario(Funcionario func) {
		repo.save(func);
	}
}
