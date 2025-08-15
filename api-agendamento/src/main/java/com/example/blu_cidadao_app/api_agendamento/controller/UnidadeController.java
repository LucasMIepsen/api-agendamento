package com.example.blu_cidadao_app.api_agendamento.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blu_cidadao_app.api_agendamento.model.Unidade;
import com.example.blu_cidadao_app.api_agendamento.service.UnidadeService;

@RestController
@RequestMapping("/unidades")
@CrossOrigin
public class UnidadeController {

	private UnidadeService servico;
	
	@Autowired
	public UnidadeController(UnidadeService servico) {
		this.servico = servico;
	}
	
	//Create
	@PostMapping
	public void inserirUnidade(@RequestBody Unidade u) {
		servico.inserirUnidade(u);
	}
	
	//Read
	@GetMapping
	public List<Unidade> listarUnidade() {
		return servico.listarUnidade();
	}
	
	@GetMapping("/{id}")
	public Optional<Unidade> obterUnidadePorId(@PathVariable int id) {
		return servico.obterUnidadePorId(id);
	}

	//Update
	@PutMapping
	public void atualizarUnidade(@RequestBody Unidade u) {
		servico.atualizarUnidade(u);
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public void deletarUnidade(@PathVariable int id) {
		servico.deletarUnidade(id);
	}
}
