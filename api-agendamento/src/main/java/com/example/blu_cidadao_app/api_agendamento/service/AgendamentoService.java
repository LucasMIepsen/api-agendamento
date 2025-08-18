package com.example.blu_cidadao_app.api_agendamento.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blu_cidadao_app.api_agendamento.model.Agendamento;
import com.example.blu_cidadao_app.api_agendamento.model.Unidade;
import com.example.blu_cidadao_app.api_agendamento.repo.AgendamentoRepo;
import com.example.blu_cidadao_app.api_agendamento.repo.UnidadeRepo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepo agendamentoRepository;

    @Autowired
    private UnidadeRepo unidadeRepository;

    public String gerarProtocolo() {
        return "AGND-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public List<LocalTime> buscarHorariosDisponiveis(Integer id_unidade, LocalDate data) {
        Unidade unidade = unidadeRepository.findById(id_unidade).orElseThrow(() -> new RuntimeException("Unidade não encontrada"));
        
        LocalDateTime inicioDia = data.atStartOfDay();
        LocalDateTime fimDia = data.atTime(LocalTime.MAX);
        
        List<Agendamento> agendamentosOcupados = agendamentoRepository.findByDataHoraBetweenAndUnidade(inicioDia, fimDia, unidade);
        
        Set<LocalTime> horariosOcupados = agendamentosOcupados.stream()
                .map(agendamento -> agendamento.getDataHora().toLocalTime())
                .collect(Collectors.toSet());
        
        List<LocalTime> todosHorarios = new ArrayList<>();
        LocalTime horario = LocalTime.of(9, 0);
        while (horario.isBefore(LocalTime.of(17, 0))) {
            todosHorarios.add(horario);
            horario = horario.plusMinutes(30);
        }
        
        return todosHorarios.stream()
                .filter(disponivel -> !horariosOcupados.contains(disponivel))
                .collect(Collectors.toList());
    }

    public Agendamento salvarAgendamento(Agendamento novoAgendamento) {
        novoAgendamento.setProtocolo(gerarProtocolo());
        return agendamentoRepository.save(novoAgendamento);
    }
}
