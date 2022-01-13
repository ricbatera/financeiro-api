package com.financeiro.domain.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.financeiro.domain.model.EntradaSaida;

import lombok.Data;

@Data
public class ParcelaRequest implements Serializable{	
	
private Long id;
	
//	private LocalDate dataVencimento;
	
	private static final long serialVersionUID = 1L;

	private LocalDate dataPagamento;
	
//	private BigDecimal valorEsperado;
	
	private BigDecimal valorEfetivo;
	
	
	private EntradaSaida entradaSaida;	
	
	
//	private String status = "Aberto";

}
