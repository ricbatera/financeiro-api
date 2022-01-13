package com.financeiro.domain.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;
import lombok.Getter;
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
	private boolean pago;
	
	public boolean getPago() {
		return this.pago;
	}
}
