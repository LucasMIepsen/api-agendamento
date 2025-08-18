package com.example.blu_cidadao_app.api_agendamento.controller;
import com.example.blu_cidadao_app.api_agendamento.repo.ServicoRepo;
import com.example.blu_cidadao_app.api_agendamento.repo.UnidadeRepo;
import com.example.blu_cidadao_app.api_agendamento.service.AgendamentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.blu_cidadao_app.api_agendamento.model.Agendamento;
import com.example.blu_cidadao_app.api_agendamento.model.Servico;
import com.example.blu_cidadao_app.api_agendamento.model.Unidade;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;
    @Autowired
    private ServicoRepo servicoRepo;

    @Autowired
    private UnidadeRepo unidadeRepo;

    AgendamentoController(UnidadeRepo unidadeRepo) {
        this.unidadeRepo = unidadeRepo;
    }

    @GetMapping("/servicos")
    public List<Servico> getAllServicos() {
        return servicoRepo.findAll();
    }

    @GetMapping("/unidades")
    public List<Unidade> getAllUnidades() {
        return unidadeRepo.findAll();
    }

    @GetMapping("/horarios")
    public List<LocalTime> getHorariosDisponiveis(@RequestParam Integer id_unidade, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        return agendamentoService.buscarHorariosDisponiveis(id_unidade, data);
    }

    @PostMapping("/agendamentos")
    public ResponseEntity<Agendamento> criarAgendamento(@RequestBody Agendamento novoAgendamento) {
        Agendamento salvo = agendamentoService.salvarAgendamento(novoAgendamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }
}

