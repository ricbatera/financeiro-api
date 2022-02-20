package com.financeiro.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financeiro.domain.model.Funcionario;
import com.financeiro.domain.service.FuncionarioService;

@CrossOrigin
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService service;
	
	@PostMapping
	public void novoFuncionario (@RequestBody Funcionario funcionario) {
		//System.out.println(funcionario);
		service.novoFuncionario(funcionario);
	}

}
