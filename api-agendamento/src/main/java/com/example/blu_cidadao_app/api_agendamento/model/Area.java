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
@Table(name = "Area")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idArea;

    @Column(nullable = false, unique = true, length = 45)
    private String nomeArea;

    @ManyToOne
    @JoinColumn(name = "Servico_idServico", nullable = false)
    private Servico servico;
    
    public Area (Integer idArea, String nomeArea, Servico servico) {
    	
    	this.idArea = idArea;
    	this.nomeArea = nomeArea;
    	this.servico = servico;
    	
    }
    
    public Integer getIdArea() {
		return idArea;
	}
    
    public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}
    
    public String getNomeArea() {
		return nomeArea;
	}
    
    public void setNomeArea(String nomeArea) {
		this.nomeArea = nomeArea;
	}
    
    public Servico getServico() {
		return servico;
	}
    
    public void setServico(Servico servico) {
		this.servico = servico;
	}

}
