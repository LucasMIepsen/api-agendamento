package com.example.blu_cidadao_app.api_agendamento.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blu_cidadao_app.api_agendamento.model.Agendamento;
import com.example.blu_cidadao_app.api_agendamento.model.Unidade;

import java.time.LocalDateTime;


public interface AgendamentoRepo extends JpaRepository<Agendamento, Integer>{
    List<Agendamento> findByDataHoraBetweenAndUnidade(LocalDateTime start, LocalDateTime end, Unidade unidade);
}

