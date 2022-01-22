package com.financeiro.domain.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.financeiro.domain.model.Parcela;

public interface ParcelaRepository extends JpaRepository<Parcela, Long>{
	
	@Query(value = "select p from Parcela p inner join p.entradaSaida e where p.dataVencimento between ?1 and ?2")
	public List<Parcela> listarFiltrandoMes(LocalDate inicio, LocalDate fim);
	
	//mesmo método anterior, porém com keywords
	public List<Parcela>findByDataVencimentoBetweenOrderByEntradaSaidaIdDesc(LocalDate inicio, LocalDate fim);
	public List<Parcela> findByentradaSaidaId(Long id);

}
