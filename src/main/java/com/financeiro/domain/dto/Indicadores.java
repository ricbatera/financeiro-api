package com.financeiro.domain.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Indicadores {

	private LocalDate dataInicial;
	private LocalDate dataFinal;
	private IndicadoresPtBr indicadoresFormatados;
	private IndicadoresEmNumeros indicadoresEmNumeros;
	public Indicadores() {
		this.indicadoresEmNumeros = new IndicadoresEmNumeros();
		this.indicadoresFormatados = new IndicadoresPtBr();
	}
	
	
}
