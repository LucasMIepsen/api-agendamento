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

import com.example.blu_cidadao_app.api_agendamento.model.Servico;
import com.example.blu_cidadao_app.api_agendamento.service.ServicoService;

@RestController
@RequestMapping("/servicos")
@CrossOrigin
public class ServicoController {

	private ServicoService servico;
	
	@Autowired
	public ServicoController(ServicoService servico) {
		this.servico = servico;
	}
	
	//Create
	@PostMapping
	public void inserirServico(@RequestBody Servico s) {
		servico.inserirServico(s);
	}
	
	//Read
	@GetMapping
	public List<Servico> listarServico() {
		return servico.listarServico();
	}
	
	@GetMapping("/{id}")
	public Optional<Servico> obterServicoPorId(@PathVariable int id) {
		return servico.obterServicoPorId(id);
	}

	//Update
	@PutMapping
	public void atualizarServico(@RequestBody Servico s) {
		servico.atualizarServico(s);
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public void deletarServico(@PathVariable int id) {
		servico.deletarServico(id);
	}
}
