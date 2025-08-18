package com.example.blu_cidadao_app.api_agendamento.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Servico")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idServico;

    @Column(nullable = false, unique = true, length = 45)
    private String nome;

    public Servico (Integer idServico, String nome, List<Area> area, List<Agendamento> agendamento) {
    	
    	this.idServico = idServico;
    	this.nome = nome;
    	
    }

	public Integer getIdServico() {
		return idServico;
	}

	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
    

}
