package com.example.blu_cidadao_app.api_agendamento.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.blu_cidadao_app.api_agendamento.model.Unidade;
import com.example.blu_cidadao_app.api_agendamento.repo.UnidadeRepo;

@Service
public class UnidadeService {

private UnidadeRepo repo;
	
	public UnidadeService(UnidadeRepo repo) {
		this.repo = repo;
	}

		// Create

		public void inserirUnidade (Unidade u) {
			repo.save(u);
		}
		
		// Read
		
		public List<Unidade> listarUnidade() {
			return repo.findAll();
		}
		
		public Optional<Unidade> obterUnidadePorId(int id) {
			return repo.findById(id);
		}
		
		//Update
		
		public void atualizarUnidade (Unidade u) {
			repo.save(u);
		}
		
		// Delete
		
		public void deletarUnidade(int id) {
			repo.deleteById(id);
		}
	
}
