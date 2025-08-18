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
	
	// Buscar por ID
    @GetMapping("/{protocolo}")
    public ResponseEntity<Agendamento> buscarAgendamento(@PathVariable String protocolo) {
        return servico.buscarPorProtocolo(protocolo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

	// Update
    // Atualizar por ID
    @PutMapping("/{id}")
    public ResponseEntity<Agendamento> atualizarAgendamento(@PathVariable int id, @RequestBody Agendamento a) {
        try {
        	Agendamento atualizada = servico.atualizarAgendamento(id, a);
            return ResponseEntity.ok(atualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
	
 // Deletar por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAgendamento(@PathVariable int id) {
        servico.deletarAgendamento(id);
        return ResponseEntity.noContent().build();
    }
	
}
