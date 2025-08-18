package com.example.blu_cidadao_app.api_agendamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.blu_cidadao_app.api_agendamento.model.Servico;
import com.example.blu_cidadao_app.api_agendamento.service.ServicoService;

import java.util.List;

@RestController
@RequestMapping("/api/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public ResponseEntity<List<Servico>> getServicos(@RequestParam(required = false) String area) {
        if (area != null && !area.isEmpty()) {
            return ResponseEntity.ok(servicoService.findByArea(area));
        }
        return ResponseEntity.ok(servicoService.findAll());
    }
}
