package com.example.blu_cidadao_app.api_agendamento.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blu_cidadao_app.api_agendamento.model.Horario;
import com.example.blu_cidadao_app.api_agendamento.repo.HorarioRepo;

@Service
public class HorarioService {

private HorarioRepo repo;
	
	@Autowired
	public HorarioService(HorarioRepo repo) {
		this.repo = repo;
	}

		// Create

		public void inserirHorario (Horario h) {
			repo.save(h);
		}
		
		// Read
		
		public List<Horario> listarHorario() {
			return repo.findAll();
		}
		
		public Optional<Horario> obterHorarioPorId(int id) {
			return repo.findById(id);
		}
		
		//Update
		
		public void atualizarHorario (Horario h) {
			repo.save(h);
		}
		
		// Delete
		
		public void deletarHorario(int id) {
			repo.deleteById(id);
		}
	
}
