package com.financeiro.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financeiro.domain.model.EntradaSaida;
import com.financeiro.domain.model.Parcela;
import com.financeiro.domain.repository.EntradaSaidaRepository;
import com.financeiro.domain.request.EntradaSaidaRequest;
import com.financeiro.domain.service.EntradaSaidaService;

@CrossOrigin
@RestController
@RequestMapping("/entradasSaidas")
public class EntradaSaidaController {
	
	@Autowired
	private EntradaSaidaService service;
	
	@Autowired
	private EntradaSaidaRepository repo;
	
	@PostMapping
	public void novaEntradaSaida(@RequestBody EntradaSaidaRequest entradaSaidaRequest) {
		service.novaEntradaSaida(entradaSaidaRequest);
	}
	
	@GetMapping
	public List<EntradaSaida> listar(){
		List<EntradaSaida> lista = repo.findAll();
		System.out.println(lista);
		return lista;
	}
	
//	@GetMapping("/listaMensal")
//	public List<EntradaSaidaMensalDTO> listaMensal(@Param(value = "inicial")String inicial, @Param(value = "fim")String fim) {
//		List<EntradaSaida> lista = new ArrayList<>();
//		return service.listarMensalFiltrado(inicial, fim);
//	}
	
	@GetMapping("/listaMensal")
	public List<EntradaSaida> listaMensal(@Param(value = "inicial")String inicial, @Param(value = "fim")String fim) {
		return service.listarMensal(inicial, fim);
	}
	
	@GetMapping("/listaParcelasMensal")
	public List<Parcela>listaParcelasMensal (@Param(value = "inicial")String inicial, @Param(value = "fim")String fim){
		return service.listarParcelasPorMes(inicial, fim);
	}
	
	@GetMapping("/pagarParcela/{id}")
	public void pagarParcela(@PathVariable Long id) {
		service.pagar(id);
	}

}
