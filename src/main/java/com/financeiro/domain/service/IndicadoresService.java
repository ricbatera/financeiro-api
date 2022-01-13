package com.financeiro.domain.service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financeiro.domain.model.EntradaSaida;
import com.financeiro.domain.model.Parcela;
import com.financeiro.domain.repository.EntradaSaidaRepository;
import com.financeiro.domain.repository.ParcelaRepository;
import com.financeiro.util.Utilitarios;

@Service
public class IndicadoresService {
	
	@Autowired
	private ParcelaRepository repo;
	
	@Autowired 
	private EntradaSaidaRepository repoEntradaSaida;
	
	public void indicadores() {
		List<Parcela> parcelas;
		LocalDate hoje = LocalDate.now();
		parcelas = repo.findByDataVencimentoBetween(Utilitarios.primeiroDiaMes(hoje), Utilitarios.ultimoDiaMes(hoje));
//		for(Parcela p : parcelas) {
//			System.out.println(p.getEntradaSaida().getTipoEntradaSaida());
//		}
		custoDiarioHoje();
		/*
		totalSaidasMes(parcelas);
		totalEntradaMes(parcelas);
		totalEntradasRecebidoMes(parcelas);
		totalSaidasPagoMes(parcelas);
		totalEntradaAbertoMes(parcelas);
		totalSaidasAbertoMes(parcelas);
		*/
	}
	
	//TOTAL DE SAÍDAS
	public BigDecimal totalSaidasMes(List<Parcela> parcelas) {
		BigDecimal total = new BigDecimal(0);
		for (Parcela p : parcelas) {
			if(p.getEntradaSaida().getTipoEntradaSaida().endsWith("Saída")) {
				total = total.add(p.getValorEsperado());
			}			
		}
		System.out.println(NumberFormat.getCurrencyInstance().format(total));
		return total;
	}

	// TOTAL DE ENTRADAS
	public BigDecimal totalEntradaMes(List<Parcela> parcelas) {
		BigDecimal total = new BigDecimal(0);
		for (Parcela p : parcelas) {
			if(p.getEntradaSaida().getTipoEntradaSaida().endsWith("Entrada")) {
				total = total.add(p.getValorEsperado());
			}			
		}
		System.out.println(NumberFormat.getCurrencyInstance().format(total));
		return total;
	}
	
	//TOTAL SAÍDAS PAGAS
	public BigDecimal totalSaidasPagoMes(List<Parcela> parcelas) {
		BigDecimal total = new BigDecimal(0);
		for (Parcela p : parcelas) {
			if(p.getStatus().equals("Pago") && p.getEntradaSaida().getTipoEntradaSaida().endsWith("Saída")) {
				total = total.add(p.getValorEfetivo());
			}
		}
		System.out.println(NumberFormat.getCurrencyInstance().format(total));
		return total;
	}
	
	
	//TOTAL DE ENTRADAS RECEBIDAS
	public BigDecimal totalEntradasRecebidoMes(List<Parcela> parcelas) {
		BigDecimal total = new BigDecimal(0);
		for (Parcela p : parcelas) {
			if(p.getStatus().equals("Pago") && p.getEntradaSaida().getTipoEntradaSaida().endsWith("Entrada")) {
				total = total.add(p.getValorEfetivo());
			}
		}
		System.out.println(NumberFormat.getCurrencyInstance().format(total));
		return total;
	}
	
	//TOTAL SAÍDAS PAGAS
		public BigDecimal totalSaidasAbertoMes(List<Parcela> parcelas) {
			BigDecimal total = new BigDecimal(0);
			for (Parcela p : parcelas) {
				if(p.getStatus().equals("Aberto") && p.getEntradaSaida().getTipoEntradaSaida().endsWith("Saída")) {
					total = total.add(p.getValorEsperado());
				}
			}
			System.out.println(NumberFormat.getCurrencyInstance().format(total));
			return total;
		}
		
		
		//TOTAL DE ENTRADAS ABERTAS
		public BigDecimal totalEntradaAbertoMes(List<Parcela> parcelas) {
			BigDecimal total = new BigDecimal(0);
			for (Parcela p : parcelas) {
				if(p.getStatus().equals("Aberto") && p.getEntradaSaida().getTipoEntradaSaida().endsWith("Entrada")) {
					total = total.add(p.getValorEsperado());
				}
			}
			System.out.println(NumberFormat.getCurrencyInstance().format(total));
			return total;
		}
		
		// BUSCANDO CUSTO DIÁRIO
		public void custoDiarioHoje() {
			BigDecimal total = new BigDecimal(0);
			List<EntradaSaida> listaCustoDiario = repoEntradaSaida.findByCustoDiarioTrue();
			for(EntradaSaida e : listaCustoDiario) {
				System.out.println(e.getDescricao());
				for(Parcela p : e.getParcelas()) {
					total = total.add(p.getValorEsperado());
				}
			}
			System.out.println(NumberFormat.getCurrencyInstance().format(total));
		}
}
