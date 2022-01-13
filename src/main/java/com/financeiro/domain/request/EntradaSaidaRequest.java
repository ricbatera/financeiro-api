package com.financeiro.domain.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.financeiro.domain.enums.TipoEntradaSaida;

import lombok.Data;
@Data
public class EntradaSaidaRequest {

	private Long id;
	private String descricao;
	private String tipoEntradaSaida;
//	private TipoEntradaSaida tipoEntradaSaidaE;
	private LocalDate dataVencimento;
	private BigDecimal valor;
	private int qtdeParcelas;
	private boolean recorrente;
	private boolean custoDiario;	
	private String observacoes;	
	private String categoria;
}
