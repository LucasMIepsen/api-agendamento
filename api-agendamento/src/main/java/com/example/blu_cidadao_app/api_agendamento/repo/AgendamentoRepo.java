package com.example.blu_cidadao_app.api_agendamento.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blu_cidadao_app.api_agendamento.model.Agendamento;

public interface AgendamentoRepo extends JpaRepository<Agendamento, Integer> {

	Optional<Agendamento> findByProtocolo(String protocolo);
	
}
