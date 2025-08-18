package com.example.blu_cidadao_app.api_agendamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blu_cidadao_app.api_agendamento.model.Servico;
import com.example.blu_cidadao_app.api_agendamento.repo.ServicoRepo;

import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepo servicoRepository;

    public List<Servico> findAll() {
        return servicoRepository.findAll();
    }

    public List<Servico> findByArea(String area) {
        return servicoRepository.findByArea(area);
    }
}
