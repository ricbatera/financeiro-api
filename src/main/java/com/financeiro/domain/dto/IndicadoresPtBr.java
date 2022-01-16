package com.financeiro.domain.dto;

import lombok.Data;

@Data
public class IndicadoresPtBr {

	private String totalEntradas;
	private String totalEntradasRecebidas;
	private String totalEntradasAbertas;
	
	private String totalSaidas;
	private String totalSaidasPagas;
	private String totalSaidasAbertas;
	
	private String custoDiario;
}
