package com.example.blu_cidadao_app.api_agendamento;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.blu_cidadao_app.api_agendamento.model.Servico;
import com.example.blu_cidadao_app.api_agendamento.model.Unidade;
import com.example.blu_cidadao_app.api_agendamento.repo.ServicoRepo;
import com.example.blu_cidadao_app.api_agendamento.repo.UnidadeRepo;

@SpringBootApplication
public class ApiAgendamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAgendamentoApplication.class, args);
	}

	
    // Método para popular o banco de dados com dados de teste ao iniciar
    @Bean
    public CommandLineRunner demoData(ServicoRepo servicoRepo, UnidadeRepo unidadeRepo) {
        return args -> {
            List<Servico> servicos = Arrays.asList(
                    new Servico(null, "Emissão de RG"),
                    new Servico(null, "Atendimento Veterinário"),
                    new Servico(null, "Vistoria de Imóvel")
            );
            servicoRepo.saveAll(servicos);

            List<Unidade> unidades = Arrays.asList(
                    new Unidade(null, "Prefeitura Central"),
                    new Unidade(null, "Unidade Regional Leste")
            );
            unidadeRepo.saveAll(unidades);
        };
    }

}
