package com.example.blu_cidadao_app.api_agendamento.repo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blu_cidadao_app.api_agendamento.model.Horario;
import com.example.blu_cidadao_app.api_agendamento.model.Unidade;

public interface HorarioRepo extends JpaRepository<Horario, Integer> {
   Horario findByDataDisponivelAndHoraDisponivelAndUnidade(LocalDate data, LocalTime hora, Unidade unidade);
}
