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

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
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
	
	@OneToMany(mappedBy = "entradaSaida", cascade = CascadeType.ALL)
	private List<Parcela>parcelas;
	
	private String tipoEntradaSaida; 
	
	private  boolean recorrente;
	
	@PrePersist
	public void setaEntradaSaidaNaLista() {
		parcelas.forEach(i -> i.setEntradaSaida(this));
	}
}
