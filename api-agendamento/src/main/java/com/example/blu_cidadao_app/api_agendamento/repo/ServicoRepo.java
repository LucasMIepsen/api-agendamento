package com.example.blu_cidadao_app.api_agendamento.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.blu_cidadao_app.api_agendamento.model.Servico;

@Repository
public interface ServicoRepo extends JpaRepository<Servico, Integer>{
    List<Servico> findByArea(String area);
}
