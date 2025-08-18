package com.example.blu_cidadao_app.api_agendamento.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "servico")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_servico;

    @Column(name = "nome")
    private String nome;

    @Column(name = "area")
    private String area;

    @Column(name = "descricao")
    private String descricao;

    public Servico() {
    }

    public Servico(Integer id_servico, String nome, String area, String descricao) {
        this.id_servico = id_servico;
        this.nome = nome;
        this.area = area;
        this.descricao = descricao;
    }

    public Integer getId_servico() {
        return id_servico;
    }

    public void setId_servico(Integer id_servico) {
        this.id_servico = id_servico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

        public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
