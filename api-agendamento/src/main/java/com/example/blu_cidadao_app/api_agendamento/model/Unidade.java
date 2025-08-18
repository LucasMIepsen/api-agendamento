package com.example.blu_cidadao_app.api_agendamento.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "unidade")
public class Unidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_unidade;

    @Column(name = "nome")
    private String nome;    

    public Unidade(){

    }

    public Unidade(Integer id_unidade, String nome){
        this.id_unidade = id_unidade;
        this.nome = nome;
    }

    public Integer getId_unidade() {
        return id_unidade;
    }

    public void setId_unidade(Integer id_unidade) {
        this.id_unidade = id_unidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
