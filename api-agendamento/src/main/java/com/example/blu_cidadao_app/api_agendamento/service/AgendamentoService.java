package com.example.blu_cidadao_app.api_agendamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.blu_cidadao_app.api_agendamento.model.Agendamento;
import com.example.blu_cidadao_app.api_agendamento.model.Servico;
import com.example.blu_cidadao_app.api_agendamento.model.Unidade;
import com.example.blu_cidadao_app.api_agendamento.model.enums.StatusAgendamento;
import com.example.blu_cidadao_app.api_agendamento.repo.AgendamentoRepo;
import com.example.blu_cidadao_app.api_agendamento.repo.ServicoRepo;
import com.example.blu_cidadao_app.api_agendamento.repo.UnidadeRepo;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepo agendamentoRepository;

    @Autowired
    private ServicoRepo servicoRepository;

    @Autowired
    private UnidadeRepo unidadeRepository;

    public Agendamento criarAgendamento(Integer id_servico, Integer id_unidade, LocalDateTime dataHora, String observacao) {
        Servico servico = servicoRepository.findById(id_servico)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço não encontrado"));

        Unidade unidade = unidadeRepository.findById(id_unidade)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Unidade não encontrada"));

        Agendamento novoAgendamento = new Agendamento();
        novoAgendamento.setServico(servico);
        novoAgendamento.setUnidade(unidade);
        novoAgendamento.setDataHora(dataHora);
        novoAgendamento.setProtocolo(UUID.randomUUID().toString().replace("-", "").substring(0, 8).toUpperCase());
        novoAgendamento.setStatus(StatusAgendamento.CONFIRMADO);

        return agendamentoRepository.save(novoAgendamento);
    }
    
    public Agendamento findByProtocolo(String protocolo) {
        return agendamentoRepository.findByProtocolo(protocolo)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento não encontrado"));
    }

    public Agendamento cancelarAgendamento(String protocolo) {
        Agendamento agendamento = findByProtocolo(protocolo);
        agendamento.setStatus(StatusAgendamento.CANCELADO);
        return agendamentoRepository.save(agendamento);
    }
}