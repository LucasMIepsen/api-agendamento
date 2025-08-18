package com.example.blu_cidadao_app.api_agendamento.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

public Agendamento inserirAgendamento(Agendamento agendamento) {
	agendamento.setProtocolo(protocoloAgendamento());
    agendamento.setData(dataAgendamento());
    return repo.save(agendamento);
}
    
 // Gerar protocolo único
    public String protocoloAgendamento() {
        return "AGD-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
    
 // Gerar data do dia
    public LocalDate dataAgendamento() {
        return LocalDate.now();
    }
	
	// Read


	public List<Agendamento> listarAgendamento() {
		return repo.findAll();
	}
	
	public Optional<Agendamento> buscarPorProtocolo(String protocolo) {
        return repo.findByProtocolo(protocolo);
    }
	
	public Agendamento atualizarAgendamento(int id, Agendamento novoAgendamento) {
	    return repo.findById(id).map(agendamento -> {
	        agendamento.setDescricao(novoAgendamento.getDescricao());
	        agendamento.setData(novoAgendamento.getData());
	        agendamento.setHora(novoAgendamento.getHora());
	        agendamento.setStatus(novoAgendamento.getStatus());
	        agendamento.setServico(novoAgendamento.getServico());
	        agendamento.setUnidade(novoAgendamento.getUnidade());
	        agendamento.setHistorico(novoAgendamento.getHistorico());
	        return repo.save(agendamento);
	    }).orElseThrow(() -> new RuntimeException("Agendamento não encontrado!"));
	}
	
	// Delete
	
	public void deletarAgendamento(int id) {
		repo.deleteById(id);
	}
	
}