package com.example.blu_cidadao_app.api_agendamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blu_cidadao_app.api_agendamento.model.Agendamento;
import com.example.blu_cidadao_app.api_agendamento.model.Horario;
import com.example.blu_cidadao_app.api_agendamento.repo.AgendamentoRepo;
import com.example.blu_cidadao_app.api_agendamento.repo.HorarioRepo;

@Service
public class AgendamentoService {

    private final AgendamentoRepo agendamentoRepo;
    private final HorarioRepo horarioRepo;

    @Autowired
    public AgendamentoService(AgendamentoRepo agendamentoRepo, HorarioRepo horarioRepo) {
        this.agendamentoRepo = agendamentoRepo;
        this.horarioRepo = horarioRepo;
    }

    // Create
    public Agendamento inserirAgendamento(Agendamento agendamento, Integer idHorario) {
        Horario horario = horarioRepo.findById(idHorario)
                .orElseThrow(() -> new RuntimeException("Horário não encontrado"));

        if (!horario.getDisponibilidade()) {
            throw new RuntimeException("Horário já está ocupado!");
        }

        // Bloqueia horário
        horario.setDisponibilidade(false);
        horarioRepo.save(horario);

        // Define status inicial
        agendamento.setStatus("AGENDADO");
        agendamento.setHora(horario.getHoraDisponivel().atDate(horario.getDataDisponivel()));

        return agendamentoRepo.save(agendamento);
    }

    // Read
    public List<Agendamento> listarAgendamento() {
        return agendamentoRepo.findAll();
    }

    public Optional<Agendamento> obterAgendamentoPorId(int id) {
        return agendamentoRepo.findById(id);
    }

    // Update
    public Agendamento atualizarAgendamento(Agendamento agendamento) {
        return agendamentoRepo.save(agendamento);
    }

    // Delete
    public void deletarAgendamento(int id) {
        Optional<Agendamento> agendamento = agendamentoRepo.findById(id);

        if (agendamento.isPresent()) {
            // libera horário antes de deletar
            Agendamento a = agendamento.get();
            Horario horario = horarioRepo.findByDataDisponivelAndHoraDisponivelAndUnidade(
                    a.getData(), a.getHora().toLocalTime(), a.getUnidade());

            if (horario != null) {
                horario.setDisponibilidade(true);
                horarioRepo.save(horario);
            }

            agendamentoRepo.deleteById(id);
        }
    }
}
