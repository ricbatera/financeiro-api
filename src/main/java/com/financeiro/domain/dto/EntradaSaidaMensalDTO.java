package com.financeiro.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.financeiro.domain.model.Parcela;

import lombok.Data;

@Data
public class EntradaSaidaMensalDTO {
	private Long id;
	private LocalDateTime dataCadastro;
	private String descricao;
	private boolean recorrente;
	private String tipoEntradaSaida;
	private List<Parcela> parcelas;
	private Long idParcela;
	private LocalDate dataPagamento;
	private LocalDate dataVencimento;
	private String status;
	private BigDecimal valorEfetivo;
	private BigDecimal valorEsperado;
}
