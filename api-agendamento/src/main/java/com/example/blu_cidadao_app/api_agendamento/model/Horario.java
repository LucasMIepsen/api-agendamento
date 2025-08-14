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
@Table(name = "Horario")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHorario;

    @Column(nullable = false, length = 45)
    private String horaDisponivel;

    @Column(nullable = false, length = 45)
    private String dataDisponivel;

    private Boolean disponibilidade;

    @ManyToOne
    @JoinColumn(name = "Unidade_idUnidade", nullable = false)
    private Unidade unidade;
    
    public Horario (Integer idHorario, String horaDisponivel, String dataDisponivel, Boolean disponibilidade) {
    	
    	this.idHorario = idHorario;
    	this.horaDisponivel = horaDisponivel;
    	this.dataDisponivel = dataDisponivel;
    	this.disponibilidade = disponibilidade;
    	
    }

	public Integer getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(Integer idHorario) {
		this.idHorario = idHorario;
	}

	public String getHoraDisponivel() {
		return horaDisponivel;
	}

	public void setHoraDisponivel(String horaDisponivel) {
		this.horaDisponivel = horaDisponivel;
	}

	public String getDataDisponivel() {
		return dataDisponivel;
	}

	public void setDataDisponivel(String dataDisponivel) {
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
