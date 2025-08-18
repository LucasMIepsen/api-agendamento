package com.example.blu_cidadao_app.api_agendamento.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blu_cidadao_app.api_agendamento.model.Servico;
import com.example.blu_cidadao_app.api_agendamento.repo.ServicoRepo;

@Service
public class ServicoService {

private ServicoRepo repo;
	
	@Autowired
	public ServicoService(ServicoRepo repo) {
		this.repo = repo;
	}

	// Create
	public void inserirServico (Servico s) {
		repo.save(s);
	}
	
	// Read
	public List<Servico> listarServico() {
		return repo.findAll();
	}
	
	public Optional<Servico> obterServicoPorId(int id) {
		return repo.findById(id);
	}
	
	//Update
	public void atualizarServico (Servico s) {
		repo.save(s);
	}
	
	// Delete
	public void deletarServico(int id) {
		repo.deleteById(id);
	}
	
}
