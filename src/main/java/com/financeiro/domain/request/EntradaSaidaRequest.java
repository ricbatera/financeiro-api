package com.financeiro.domain.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;
@Data
public class EntradaSaidaRequest {

	private Long id;
	private String descricao;
	private String tipoEntradaSaida;
	private LocalDate dataVencimento;
	private BigDecimal valor;
	private int qtdeParcelas;
	private boolean recorrente;
}
