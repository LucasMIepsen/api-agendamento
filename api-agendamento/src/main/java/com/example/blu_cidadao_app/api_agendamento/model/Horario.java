package com.example.blu_cidadao_app.api_agendamento.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Horario")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHorario;

    @Column(nullable = false)
    private LocalTime horaDisponivel;   

    @Column(nullable = false)
    private LocalDate dataDisponivel;   

    @Column(nullable = false)
    private Boolean disponibilidade;

    @ManyToOne
    @JoinColumn(name = "Unidade_idUnidade", nullable = false)
    private Unidade unidade;

    // Construtor vazio (obrigatório para JPA)
    public Horario() {}

    // Construtor completo
    public Horario(Integer idHorario, LocalTime horaDisponivel, LocalDate dataDisponivel,
                   Boolean disponibilidade, Unidade unidade) {
        this.idHorario = idHorario;
        this.horaDisponivel = horaDisponivel;
        this.dataDisponivel = dataDisponivel;
        this.disponibilidade = disponibilidade;
        this.unidade = unidade;
    }

    // getters e setters
    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public LocalTime getHoraDisponivel() {
        return horaDisponivel;
    }

    public void setHoraDisponivel(LocalTime horaDisponivel) {
        this.horaDisponivel = horaDisponivel;
    }

    public LocalDate getDataDisponivel() {
        return dataDisponivel;
    }

    public void setDataDisponivel(LocalDate dataDisponivel) {
        this.dataDisponivel = dataDisponivel;
    }

    public Boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }
}
