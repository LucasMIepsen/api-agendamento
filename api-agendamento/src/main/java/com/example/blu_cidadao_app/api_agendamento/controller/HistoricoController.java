package com.example.blu_cidadao_app.api_agendamento.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blu_cidadao_app.api_agendamento.model.Historico;
import com.example.blu_cidadao_app.api_agendamento.service.HistoricoService;

@RestController
@RequestMapping("/historicos")
@CrossOrigin
public class HistoricoController {

	private HistoricoService servico;
	
	public HistoricoController(HistoricoService servico) {
		this.servico = servico;
	}
	
	//Create
	@PostMapping
	public void inserirHistorico(@RequestBody Historico h) {
		servico.inserirHistorico(h);
	}
	
	//Read
	@GetMapping
	public List<Historico> listarHistorico() {
		return servico.listarHistorico();
	}
	
	@GetMapping("/{id}")
	public Optional<Historico> obterHistoricoPorId(@PathVariable int id) {
		return servico.obterHistoricoPorId(id);
	}

	//Update
	@PutMapping
	public void atualizarHistorico(@RequestBody Historico h) {
		servico.atualizarHistorico(h);
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public void deletarHistorico(@PathVariable int id) {
		servico.deletarHistorico(id);
	}
}
