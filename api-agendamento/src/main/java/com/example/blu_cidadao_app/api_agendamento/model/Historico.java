package com.example.blu_cidadao_app.api_agendamento.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Historico")
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHistorico;

    @Column(length = 45)
    private String dataEvento;

    @Column(length = 45)
    private String descricao;

    @Column(length = 45)
    private String status;

    @ManyToOne
    @JoinColumn(name = "Agendamento_idAgendamento", nullable = false)
    private Agendamento agendamento;
    
    public Historico (Integer idHistorico, String dataEvento, String descricao, String status, Agendamento agendamento) {
    	
    	this.idHistorico = idHistorico;
    	this.dataEvento = dataEvento;
    	this.descricao = descricao;
    	this.status = status;
    	this.agendamento = agendamento;
    	
    }

	public Integer getIdHistorico() {
		return idHistorico;
	}

	public void setIdHistorico(Integer idHistorico) {
		this.idHistorico = idHistorico;
	}

	public String getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(String dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}
    
    

}
