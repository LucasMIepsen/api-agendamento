package com.example.blu_cidadao_app.api_agendamento.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blu_cidadao_app.api_agendamento.model.Horario;

public interface HorarioRepo extends JpaRepository<Horario, Integer> {

}
