package com.example.blu_cidadao_app.api_agendamento.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.blu_cidadao_app.api_agendamento.model.Area;
import com.example.blu_cidadao_app.api_agendamento.repo.AreaRepo;

@Service
public class AreaService {

	private AreaRepo repo;
	
	public AreaService(AreaRepo repo) {
		this.repo = repo;
	}

	// Create
	public void inserirArea (Area a) {
		repo.save(a);
	}

	// Read
	public List<Area> listarArea() {
		return repo.findAll();
	}
	public Optional<Area> obterAreaPorId(int id) {
		return repo.findById(id);
	}
	
	//Update
	public void atualizarArea (Area a) {
		repo.save(a);
	}
	
	// Delete
	public void deletarArea(int id) {
		repo.deleteById(id);
	}
	
}
