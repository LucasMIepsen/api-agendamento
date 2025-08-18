package com.example.blu_cidadao_app.api_agendamento.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.blu_cidadao_app.api_agendamento.model.Historico;
import com.example.blu_cidadao_app.api_agendamento.repo.HistoricoRepo;

@Service
public class HistoricoService {

private HistoricoRepo repo;
	
	public HistoricoService(HistoricoRepo repo) {
		this.repo = repo;
	}

		// Create

		public void inserirHistorico (Historico h) {
			repo.save(h);
		}
		
		// Read
		
		public List<Historico> listarHistorico() {
			return repo.findAll();
		}
		
		public Optional<Historico> obterHistoricoPorId(int id) {
			return repo.findById(id);
		}
		
		//Update
		
		public void atualizarHistorico (Historico h) {
			repo.save(h);
		}
		
		// Delete
		
		public void deletarHistorico(int id) {
			repo.deleteById(id);
		}
	
}
