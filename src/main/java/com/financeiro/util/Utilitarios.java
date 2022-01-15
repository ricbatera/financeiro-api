package com.financeiro.util;

import java.time.LocalDate;

public class Utilitarios {
	
	public static LocalDate primeiroDiaMes(LocalDate data) {
		return data.withDayOfMonth(1);
	}
	
	//retorna a data setando o último dia do mês
	public static LocalDate ultimoDiaMes(LocalDate data) {
		return data.withDayOfMonth(data.lengthOfMonth());
	}

}
