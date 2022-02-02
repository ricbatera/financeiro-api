package com.financeiro.domain.service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financeiro.domain.dto.Indicadores;
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
	
	public Indicadores indicadores(String data) {		
		Indicadores indicadores = new Indicadores();
		LocalDate agora = LocalDate.now();
		LocalDate hoje = LocalDate.parse(data);
		LocalDate dataInicial = Utilitarios.primeiroDiaMes(hoje);
		LocalDate dataFinal = Utilitarios.ultimoDiaMes(hoje);
		List<Parcela> parcelas = repo.findByDataVencimentoBetweenOrderByDataVencimentoDesc(dataInicial, dataFinal);
		
		//obtendo os indicadores
		BigDecimal totalSaidas = totalSaidasMes(parcelas);
		BigDecimal totalSaidasAbertas = totalSaidasAbertoMes(parcelas);
		BigDecimal totalSaidasPagas = totalSaidasPagoMes(parcelas);
		
		BigDecimal totalEntradas = totalEntradaMes(parcelas);
		BigDecimal totalEntradasRecebidas = totalEntradasRecebidoMes(parcelas);
		BigDecimal totalEntradasAbertas = totalEntradaAbertoMes(parcelas);
		
		BigDecimal custoDiario = custoDiarioHoje(agora);
		//setando a data inicial e final
		indicadores.setDataInicial(dataInicial);
		indicadores.setDataFinal(dataFinal);
		
		//setando indicadores numericos:
		indicadores.getIndicadoresEmNumeros().setCustoDiario(custoDiario);
		
		indicadores.getIndicadoresEmNumeros().setTotalEntradas(totalEntradasAbertas);
		indicadores.getIndicadoresEmNumeros().setTotalEntradasAbertas(totalEntradasAbertas);
		indicadores.getIndicadoresEmNumeros().setTotalEntradasRecebidas(totalEntradasRecebidas);
		
		indicadores.getIndicadoresEmNumeros().setTotalSaidas(totalSaidas);
		indicadores.getIndicadoresEmNumeros().setTotalSaidasAbertas(totalSaidasAbertas);
		indicadores.getIndicadoresEmNumeros().setTotalSaidasPagas(totalSaidasPagas);
		
		
		//setando indicadores formatados:
		indicadores.getIndicadoresFormatados().setCustoDiario(Utilitarios.formataValorMonetario(custoDiario));
		
		indicadores.getIndicadoresFormatados().setTotalEntradas(Utilitarios.formataValorMonetario(totalEntradas));
		indicadores.getIndicadoresFormatados().setTotalEntradasRecebidas(Utilitarios.formataValorMonetario(totalEntradasRecebidas));
		indicadores.getIndicadoresFormatados().setTotalEntradasAbertas(Utilitarios.formataValorMonetario(totalEntradasAbertas));
		
		indicadores.getIndicadoresFormatados().setTotalSaidas(Utilitarios.formataValorMonetario(totalSaidas));
		indicadores.getIndicadoresFormatados().setTotalSaidasAbertas(Utilitarios.formataValorMonetario(totalSaidasAbertas));
		indicadores.getIndicadoresFormatados().setTotalSaidasPagas(Utilitarios.formataValorMonetario(totalSaidasPagas));

		
		//retorna o objeto completo com os indicadores... esse objeto irá evoluindo conforme a necessidade
		return indicadores;
	}
	
	//TOTAL DE SAÍDAS
	private BigDecimal totalSaidasMes(List<Parcela> parcelas) {
		BigDecimal total = new BigDecimal(0);
		for (Parcela p : parcelas) {
			if(p.getEntradaSaida().getTipoEntradaSaida().endsWith("Saída")) {
				total = total.add(p.getValorEsperado());
			}			
		}
		//System.out.println(NumberFormat.getCurrencyInstance().format(total));
		return total;
	}

	// TOTAL DE ENTRADAS
	private BigDecimal totalEntradaMes(List<Parcela> parcelas) {
		BigDecimal total = new BigDecimal(0);
		for (Parcela p : parcelas) {
			if(p.getEntradaSaida().getTipoEntradaSaida().endsWith("Entrada")) {
				total = total.add(p.getValorEsperado());
			}			
		}
		//System.out.println(NumberFormat.getCurrencyInstance().format(total));
		return total;
	}
	
	//TOTAL SAÍDAS PAGAS
	private BigDecimal totalSaidasPagoMes(List<Parcela> parcelas) {
		BigDecimal total = new BigDecimal(0);
		for (Parcela p : parcelas) {
			if(p.getStatus().equals("Pago") && p.getEntradaSaida().getTipoEntradaSaida().endsWith("Saída")) {
				total = total.add(p.getValorEfetivo());
			}
		}
		//System.out.println(NumberFormat.getCurrencyInstance().format(total));
		return total;
	}
	
	
	//TOTAL DE ENTRADAS RECEBIDAS
	private BigDecimal totalEntradasRecebidoMes(List<Parcela> parcelas) {
		BigDecimal total = new BigDecimal(0);
		for (Parcela p : parcelas) {
			if(p.getStatus().equals("Pago") && p.getEntradaSaida().getTipoEntradaSaida().endsWith("Entrada")) {
				total = total.add(p.getValorEfetivo());
			}
		}
		//System.out.println(NumberFormat.getCurrencyInstance().format(total));
		return total;
	}
	
	//TOTAL SAÍDAS ABERTAS
		private BigDecimal totalSaidasAbertoMes(List<Parcela> parcelas) {
			BigDecimal total = new BigDecimal(0);
			for (Parcela p : parcelas) {
				if(p.getStatus().equals("Aberto") && p.getEntradaSaida().getTipoEntradaSaida().endsWith("Saída")) {
					total = total.add(p.getValorEsperado());
				}
			}
			//System.out.println(NumberFormat.getCurrencyInstance().format(total));
			return total;
		}
		
		
		//TOTAL DE ENTRADAS ABERTAS
		private BigDecimal totalEntradaAbertoMes(List<Parcela> parcelas) {
			BigDecimal total = new BigDecimal(0);
			for (Parcela p : parcelas) {
				if(p.getStatus().equals("Aberto") && p.getEntradaSaida().getTipoEntradaSaida().endsWith("Entrada")) {
					total = total.add(p.getValorEsperado());
				}
			}
			//System.out.println(NumberFormat.getCurrencyInstance().format(total));
			return total;
		}
		
		// BUSCANDO CUSTO DIÁRIO
		private BigDecimal custoDiarioHoje(LocalDate hoje) {
			BigDecimal total = new BigDecimal(0);
			List<EntradaSaida> listaCustoDiario = repoEntradaSaida.findByCustoDiarioTrue();
			for(EntradaSaida e : listaCustoDiario) {
				LocalDate dataCad =e.getDataCadastro().toLocalDate();
				if(dataCad.equals(hoje)) {
					for(Parcela p : e.getParcelas()) {					
						total = total.add(p.getValorEsperado());
					}
				}				
			}
			return total;
		}
}
