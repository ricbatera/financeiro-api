package com.financeiro.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Parcela {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate dataVencimento;
	
	private LocalDate dataPagamento;
	
	private BigDecimal valorEsperado;
	
	private BigDecimal valorEfetivo;
	
	@JsonManagedReference
//	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "entrada_saida_id")
	private EntradaSaida entradaSaida;	
	
	
	private String status = "Aberto";

}
