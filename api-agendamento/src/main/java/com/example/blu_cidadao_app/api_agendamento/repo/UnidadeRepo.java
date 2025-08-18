package com.example.blu_cidadao_app.api_agendamento.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.blu_cidadao_app.api_agendamento.model.Unidade;

@Repository
public interface UnidadeRepo extends JpaRepository<Unidade, Integer> {
    
}
