package com.financeiro.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financeiro.domain.request.EntradaSaidaRequest;
import com.financeiro.domain.service.EntradaSaidaService;

@RestController
@RequestMapping("/entradasSaidas")
public class EntradaSaidaController {
	
	@Autowired
	private EntradaSaidaService service;
	
	@PostMapping
	public void novaEntradaSaida(@RequestBody EntradaSaidaRequest entradaSaidaRequest) {
		service.novaEntradaSaida(entradaSaidaRequest);
	}

}
