package com.financeiro.domain.request;

import lombok.Data;
@Data
public class EntradaSaidaRequestEditar {

	private Long id;
	private String descricao;
	private boolean custoDiario;	
	private String observacoes;	
	private String categoria;
}
