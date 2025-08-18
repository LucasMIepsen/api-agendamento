package com.example.blu_cidadao_app.api_agendamento.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Agendamento")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAgendamento;

    @Column(nullable = false, length = 255)
    private String descricao;

    @Column(nullable = false, unique = true)
    private LocalDate data;

    @Column(length = 45)
    private String protocolo;

    @Column(nullable = false)
    private LocalDateTime hora;

    @Column(nullable = false, length = 45)
    private String status;

    @ManyToOne
    @JoinColumn(name = "Servico_idServico", nullable = false)
    private Servico servico;

    @ManyToOne
    @JoinColumn(name = "Unidade_idUnidade", nullable = false)
    private Unidade unidade;

    @OneToMany(mappedBy = "agendamento", cascade = CascadeType.ALL)
    private List<Historico> historico;
    
    
  //Construtor vazio
    public Agendamento() {
        this.data = LocalDate.now();
        this.protocolo = gerarProtocolo();
    }

    //Função de gerar protcolo
    private String gerarProtocolo(){
        return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
    

public Agendamento (Integer idAgendamento, String descricao, LocalDate data, String protocolo, LocalDateTime hora, String status, Servico servico, Unidade unidade, List<Historico> historico) {
	
	this.idAgendamento = idAgendamento;
	this.descricao = descricao;
	this.data = data;
	this.hora = hora;
	this.status = status;
	this.protocolo = protocolo;
	this.servico = servico;
	this.unidade = unidade;
	this.historico = historico;
			
}

public Integer getIdAgendamento() {
	return idAgendamento;
}

public void setIdAgendamento(Integer idAgendamento) {
	this.idAgendamento = idAgendamento;
}

public String getDescricao() {
	return descricao;
}

public void setDescricao(String descricao) {
	this.descricao = descricao;
}

public LocalDate getData() {
	return data;
}

public void setData(LocalDate data) {
	this.data = data;
}

public LocalDateTime getHora() {
	return hora;
}

public void setHora(LocalDateTime hora) {
	this.hora = hora;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getProtocolo() {
	return protocolo;
}

public void setProtocolo(String protocolo) {
	this.protocolo = protocolo;
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

public List<Historico> getHistorico() {
	return historico;
}

public void setHistorico(List<Historico> historico) {
	this.historico = historico;
}
	
}
