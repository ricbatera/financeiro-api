package com.financeiro.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financeiro.domain.model.EntradaSaida;

public interface EntradaSaidaRepository extends JpaRepository<EntradaSaida, Long>{

}
