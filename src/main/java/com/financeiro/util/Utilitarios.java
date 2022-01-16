package com.financeiro.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;

public class Utilitarios {
	
	public static LocalDate primeiroDiaMes(LocalDate data) {
		return data.withDayOfMonth(1);
	}
	
	//retorna a data setando o último dia do mês
	public static LocalDate ultimoDiaMes(LocalDate data) {
		return data.withDayOfMonth(data.lengthOfMonth());
	}
// recebe um bigDecimal e retorna uma String formatada
	public static String formataValorMonetario(BigDecimal valor) {
		return NumberFormat.getCurrencyInstance().format(valor);
	}
}
