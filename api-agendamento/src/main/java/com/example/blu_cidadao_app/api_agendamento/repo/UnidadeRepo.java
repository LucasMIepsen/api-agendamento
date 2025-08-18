package com.example.blu_cidadao_app.api_agendamento.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blu_cidadao_app.api_agendamento.model.Unidade;

public interface UnidadeRepo extends JpaRepository<Unidade, Integer> {
    
}
