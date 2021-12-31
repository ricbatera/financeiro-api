package com.financeiro.domain;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.financeiro.domain.dto.EntradaSaidaMensalDTO;
import com.financeiro.domain.model.EntradaSaida;

public interface EntradaSaidaRepository extends JpaRepository<EntradaSaida, Long>{
	
//	@Query(value = "select a.descricao from entrada_saida as a\r\n" + 
//			"inner join parcela as b on a.id = b.entrada_saida_id\r\n" + 
//			"where data_vencimento between ?1 and ?2", nativeQuery = true)
	
	@Query(value = "select us from EntradaSaida us inner join us.parcelas b where b.dataVencimento between ?1 and ?2")
	public List<EntradaSaida> listarMensal(LocalDate inicio, LocalDate fim);
	

}
