package com.example.blu_cidadao_app.api_agendamento.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blu_cidadao_app.api_agendamento.model.Area;
import com.example.blu_cidadao_app.api_agendamento.service.AreaService;

@RestController
@RequestMapping("/areas")
@CrossOrigin
public class AreaController {

	private AreaService servico;
	
	public AreaController(AreaService servico) {
		this.servico = servico;
	}
	
	//Create
	@PostMapping
	public void inserirArea(@RequestBody Area a) {
		servico.inserirArea(a);
	}
	
	//Read
	@GetMapping
	public List<Area> listarArea() {
		return servico.listarArea();
	}
	
	@GetMapping("/{id}")
	public Optional<Area> obterAreaPorId(@PathVariable int id) {
		return servico.obterAreaPorId(id);
	}

	//Update
	@PutMapping
	public void atualizarArea(@RequestBody Area a) {
		servico.atualizarArea(a);
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public void deletarArea(@PathVariable int id) {
		servico.deletarArea(id);
	}
}
