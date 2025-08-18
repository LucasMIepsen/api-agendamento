package com.example.blu_cidadao_app.api_agendamento.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "agendamento")
public class Agendamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_agendamento;

    @Column(name = "protocolo")
    private String protocolo;

    @Column(name = "dataHora")
    private LocalDateTime dataHora;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne
    private Servico servico;

    @ManyToOne
    private Unidade unidade;

    public Agendamento(){

    }

    public Agendamento(Integer id_agendamento, String protocolo, LocalDateTime dataHora, String descricao,
            Servico servico, Unidade unidade) {
        this.id_agendamento = id_agendamento;
        this.protocolo = protocolo;
        this.dataHora = dataHora;
        this.descricao = descricao;
        this.servico = servico;
        this.unidade = unidade;
    }

    public Integer getId_agendamento() {
        return id_agendamento;
    }

    public void setId_agendamento(Integer id_agendamento) {
        this.id_agendamento = id_agendamento;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    
}
