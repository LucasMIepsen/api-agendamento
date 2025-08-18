package com.example.blu_cidadao_app.api_agendamento.model;

import java.time.LocalDateTime;

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
    private LocalDateTime dataEvento;


    @Column(length = 45)
    private String status;

    @ManyToOne
    @JoinColumn(name = "Agendamento_idAgendamento", nullable = false)
    private Agendamento agendamento;
    
    public Historico (Integer idHistorico, LocalDateTime dataEvento, String descricao, String status, Agendamento agendamento) {
    	
    	this.idHistorico = idHistorico;
    	this.dataEvento = dataEvento;
    	this.status = status;
    	this.agendamento = agendamento;
    	
    }

	public Integer getIdHistorico() {
		return idHistorico;
	}

	public void setIdHistorico(Integer idHistorico) {
		this.idHistorico = idHistorico;
	}

	public LocalDateTime getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(LocalDateTime dataEvento) {
		this.dataEvento = dataEvento;
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
