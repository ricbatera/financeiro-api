package com.financeiro.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financeiro.domain.dto.Indicadores;
import com.financeiro.domain.service.IndicadoresService;

@CrossOrigin
@RestController
@RequestMapping("/indicadores")
public class IndicadoresController {
	
	@Autowired
	private IndicadoresService service;
	
	@GetMapping
	public Indicadores indicadores() {
		 return service.indicadores();
	}

}
