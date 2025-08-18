package com.example.blu_cidadao_app.api_agendamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.blu_cidadao_app.api_agendamento.model.Agendamento;
import com.example.blu_cidadao_app.api_agendamento.service.AgendamentoService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<Agendamento> criarAgendamento(
            @RequestParam Integer id_servico,
            @RequestParam Integer id_unidade,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataHora,
            @RequestParam(required = false) String observacao) {
        
        Agendamento novoAgendamento = agendamentoService.criarAgendamento(id_servico, id_unidade, dataHora, observacao);
        return new ResponseEntity<>(novoAgendamento, HttpStatus.CREATED);
    }

    @GetMapping("/{protocolo}")
    public ResponseEntity<Agendamento> getAgendamentoByProtocolo(@PathVariable String protocolo) {
        Agendamento agendamento = agendamentoService.findByProtocolo(protocolo);
        return ResponseEntity.ok(agendamento);
    }

    @DeleteMapping("/{protocolo}")
    public ResponseEntity<Agendamento> cancelarAgendamento(@PathVariable String protocolo) {
        Agendamento agendamentoCancelado = agendamentoService.cancelarAgendamento(protocolo);
        return ResponseEntity.ok(agendamentoCancelado);
    }
}