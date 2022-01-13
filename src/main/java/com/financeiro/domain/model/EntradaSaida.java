package com.financeiro.domain.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.financeiro.domain.enums.TipoEntradaSaida;

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
public class EntradaSaida {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	
//	@Temporal(TemporalType.TIMESTAMP)     
//	private Date dataCadastro = new java.sql.Date(System.currentTimeMillis());
	
	private LocalDateTime dataCadastro = LocalDateTime.now();
	
//	LocalDateTime dataCadastro = LocalDateTime.ofInstant(Instant.now(), ZoneId.of("America/Sao_Paulo"));
	
	@JsonBackReference
//	@JsonManagedReference
	@OneToMany(mappedBy = "entradaSaida", cascade = CascadeType.ALL)
	private List<Parcela>parcelas;
	
	private String tipoEntradaSaida;
	
//	private TipoEntradaSaida tipoEntradaSaidaE;
	
	private  boolean recorrente;
	
	private boolean custoDiario;
	
	private String observacoes;
	
	private String categoria;
	
	@PrePersist
	public void setaEntradaSaidaNaLista() {
		parcelas.forEach(i -> i.setEntradaSaida(this));
	}
}
