package com.financeiro.util;

import java.time.LocalDate;

public class Utilitarios {
	
	public static LocalDate primeiroDiaMes(LocalDate data) {
		return data.withDayOfMonth(1);
	}
	
	public static LocalDate ultimoDiaMes(LocalDate data) {
		return data.withDayOfMonth(data.lengthOfMonth());
	}

}
