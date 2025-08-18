package com.example.blu_cidadao_app.api_agendamento.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
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
@RequestMapping("/agendamentos")
@CrossOrigin
public class AgendamentoController {

	private AgendamentoService servico;
	

	public AgendamentoController(AgendamentoService servico) {
		this.servico = servico;
	}
	
	//Create
	@PostMapping
    public ResponseEntity<Agendamento> inserirAgendamento(@RequestBody Agendamento a) {
        Agendamento nova = servico.inserirAgendamento(a);
        return ResponseEntity.ok(nova);
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

	// Update
	@PutMapping("/{id}")
	public Agendamento atualizarAgendamento(@PathVariable int id, @RequestBody Agendamento a) {
	    return servico.atualizarAgendamento(id, a);
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public void deletarAgendamento(@PathVariable int id) {
		servico.deletarAgendamento(id);
	}
	
}
