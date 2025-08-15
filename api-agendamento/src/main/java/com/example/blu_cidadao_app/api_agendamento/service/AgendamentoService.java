package com.example.blu_cidadao_app.api_agendamento.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blu_cidadao_app.api_agendamento.model.Agendamento;
import com.example.blu_cidadao_app.api_agendamento.repo.AgendamentoRepo;

@Service
public class AgendamentoService {

private AgendamentoRepo repo;
	
@Autowired
public AgendamentoService(AgendamentoRepo repo) {
	this.repo = repo;
}

	// Create

	public void inserirAgendamento (Agendamento a) {
		a.setData(LocalDate.now());
		repo.save(a);
	}
	
	// Read
	
	public List<Agendamento> listarAgendamento() {
		return repo.findAll();
	}
	
	public Optional<Agendamento> obterAgendamentoPorId(int id) {
		return repo.findById(id);
	}
	
	//Update
	
	public void atualizarAgendamento (Agendamento a) {
		repo.save(a);
	}
	
	// Delete
	
	public void deletarAgendamento(int id) {
		repo.deleteById(id);
	}
	
}