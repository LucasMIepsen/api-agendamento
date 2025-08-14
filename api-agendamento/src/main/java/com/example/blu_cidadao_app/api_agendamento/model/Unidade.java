package com.example.blu_cidadao_app.api_agendamento.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Unidade")
public class Unidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUnidade;

    @Column(nullable = false, length = 45)
    private String nome;

    @Column(length = 45)
    private String endereco;

    @OneToMany(mappedBy = "unidade", cascade = CascadeType.ALL)
    private List<Agendamento> agendamento;

    @OneToMany(mappedBy = "unidade", cascade = CascadeType.ALL)
    private List<Horario> horario;

    public Unidade (Integer idUnidade, String nome, String endereco, List<Agendamento> agendamento, List<Horario> horario) {
    	
    	this.idUnidade = idUnidade;
    	this.nome = nome;
    	this.endereco = endereco;
    	this.agendamento = agendamento;
    	this.horario = horario;
    	
    }

	public Integer getIdUnidade() {
		return idUnidade;
	}

	public void setIdUnidade(Integer idUnidade) {
		this.idUnidade = idUnidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Agendamento> getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(List<Agendamento> agendamento) {
		this.agendamento = agendamento;
	}

	public List<Horario> getHorario() {
		return horario;
	}

	public void setHorario(List<Horario> horario) {
		this.horario = horario;
	}

    
    
}
