package com.example.blu_cidadao_app.api_agendamento.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blu_cidadao_app.api_agendamento.model.Horario;
import com.example.blu_cidadao_app.api_agendamento.service.HorarioService;

@RestController
@RequestMapping("/horarios")
@CrossOrigin
public class HorarioController {

	private HorarioService servico;
	
	@Autowired
	public HorarioController(HorarioService servico) {
		this.servico = servico;
	}
	
	//Create
	@PostMapping
	public void inserirHorario(@RequestBody Horario h) {
		servico.inserirHorario(h);
	}
	
	//Read
	@GetMapping
	public List<Horario> listarHorario() {
		return servico.listarHorario();
	}
	
	@GetMapping("/{id}")
	public Optional<Horario> obterHorarioPorId(@PathVariable int id) {
		return servico.obterHorarioPorId(id);
	}

	//Update
	@PutMapping
	public void atualizarHorario(@RequestBody Horario h) {
		servico.atualizarHorario(h);
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public void deletarHorario(@PathVariable int id) {
		servico.deletarHorario(id);
	}
}
