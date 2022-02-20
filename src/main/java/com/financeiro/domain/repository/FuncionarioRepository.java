package com.financeiro.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financeiro.domain.model.Funcionario;

public interface FuncionarioRepository  extends JpaRepository<Funcionario, Long>{

}
