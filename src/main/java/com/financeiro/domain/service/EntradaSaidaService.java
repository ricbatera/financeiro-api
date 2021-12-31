package com.financeiro.domain.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financeiro.domain.EntradaSaidaRepository;
import com.financeiro.domain.dto.EntradaSaidaMensalDTO;
import com.financeiro.domain.mapper.EntradaSaidaMapper;
import com.financeiro.domain.model.EntradaSaida;
import com.financeiro.domain.model.Parcela;
import com.financeiro.domain.request.EntradaSaidaRequest;

@Service
public class EntradaSaidaService {
	@Autowired
	private EntradaSaidaRepository repo;
	
	@Autowired
	private EntradaSaidaMapper mapper;
	
	public void novaEntradaSaida(EntradaSaidaRequest entradaSaidaRequest) {
		EntradaSaida entradaSaida = new EntradaSaida();
		BeanUtils.copyProperties(entradaSaidaRequest, entradaSaida);
		entradaSaida.setParcelas(gerarParcelas(entradaSaidaRequest.getQtdeParcelas(), entradaSaidaRequest.getDataVencimento(), entradaSaidaRequest.getValor()));
		System.out.println(entradaSaida);
		repo.save(entradaSaida);
	}
	
	public List<EntradaSaida> listarMensal(String inicio, String fim) {
		LocalDate dtIn = LocalDate.parse(inicio);
		LocalDate dtFim = LocalDate.parse(fim);
		List<EntradaSaida> lista = new ArrayList<>();
//		lista = repo.listarMensal();
		lista = repo.listarMensal(dtIn, dtFim);
		System.out.println(lista);
		return lista;
	}
	
//	public List<EntradaSaidaMensalDTO> listarMensalFiltrado(String inicio, String fim){
//		LocalDate dtIn = LocalDate.parse(inicio);
//		LocalDate dtFim = LocalDate.parse(fim);
//		return repo.listarMensal(dtIn, dtFim).stream().map(item -> mapper.entradaSaidaToDto(item)).collect(Collectors.toList());
//	}
	
	public List<Parcela> gerarParcelas(int qtdeParcelas, LocalDate dataVencimento, BigDecimal valor) {
		List<Parcela>parcelas = new ArrayList<>();
		Calendar vencimento = converteVencimento(dataVencimento);
		for(int i =0;  i<qtdeParcelas; i ++) {
			LocalDate venc = LocalDateTime.ofInstant(vencimento.toInstant(), vencimento.getTimeZone().toZoneId()).toLocalDate();
			Parcela parcela = new Parcela();
			parcela.setDataVencimento(venc);
			parcela.setValorEsperado(valor);
			parcelas.add(parcela);
			vencimento.set(Calendar.MONTH, (vencimento.get(Calendar.MONTH)+1));
		}
		return parcelas;
		
	}
	private Calendar converteVencimento(LocalDate vencimento) {
		String dataVencimento = vencimento.toString();
		String [] arrayVencimento = dataVencimento.split("-");
		Integer ano = Integer.valueOf(arrayVencimento[0]);
		Integer mes = Integer.valueOf(arrayVencimento[1])-1;
		Integer dia = Integer.valueOf(arrayVencimento[2]);
		Calendar vencimentoCalendar = Calendar.getInstance();		
		vencimentoCalendar.set(Calendar.DAY_OF_MONTH, dia);
		vencimentoCalendar.set(Calendar.MONTH, mes);
		vencimentoCalendar.set(Calendar.YEAR, ano);
		return vencimentoCalendar;
	}

}
