package com.financeiro.domain.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class IndicadoresEmNumeros {

	private BigDecimal totalEntradas;
	private BigDecimal totalEntradasRecebidas;
	private BigDecimal totalEntradasAbertas;
	
	private BigDecimal totalSaidas;
	private BigDecimal totalSaidasPagas;
	private BigDecimal totalSaidasAbertas;
	
	private BigDecimal custoDiario;
}
