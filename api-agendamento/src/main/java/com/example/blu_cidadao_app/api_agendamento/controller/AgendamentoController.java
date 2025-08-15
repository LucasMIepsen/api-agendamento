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

import com.example.blu_cidadao_app.api_agendamento.model.Agendamento;
import com.example.blu_cidadao_app.api_agendamento.service.AgendamentoService;

@RestController
@RequestMapping("/Agendamento")
@CrossOrigin
public class AgendamentoController {

	private AgendamentoService servico;
	
	@Autowired
	public AgendamentoController(AgendamentoService servico) {
		this.servico = servico;
	}
	
	//Create
	@PostMapping
	public void inserirAgendamento(@RequestBody Agendamento a) {
		servico.inserirAgendamento(a);
	}
	
	//Read
	@GetMapping
	public List<Agendamento> listarAgendamento() {
		return servico.listarAgendamento();
	}
	
	@GetMapping("/{id}")
	public Optional<Agendamento> obterAgendamentoPorId(@PathVariable int id) {
		return servico.obterAgendamentoPorId(id);
	}

	//Update
	@PutMapping
	public void atualizarAgendamento(@RequestBody Agendamento a) {
		servico.atualizarAgendamento(a);
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public void deletarAgendamento(@PathVariable int id) {
		servico.deletarAgendamento(id);
	}
	
}
