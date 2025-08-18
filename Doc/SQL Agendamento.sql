CREATE TABLE Servico (
    idServico INTEGER AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL UNIQUE
);

CREATE TABLE Unidade (
    idUnidade INTEGER AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL,
    endereco VARCHAR(45)
);

CREATE TABLE Area (
    idArea INTEGER AUTO_INCREMENT PRIMARY KEY,
    nomeArea VARCHAR(45) NOT NULL UNIQUE,
    Servico_idServico INTEGER NOT NULL,
    FOREIGN KEY (Servico_idServico) REFERENCES Servico(idServico)
);

CREATE TABLE Agendamento (
    idAgendamento INTEGER AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
    data DATE NOT NULL UNIQUE,
    protocolo VARCHAR(45),
    hora DATETIME NOT NULL,
    status VARCHAR(45) NOT NULL,
    Servico_idServico INTEGER NOT NULL,
    Unidade_idUnidade INTEGER NOT NULL,
    FOREIGN KEY (Servico_idServico) REFERENCES Servico(idServico),
    FOREIGN KEY (Unidade_idUnidade) REFERENCES Unidade(idUnidade)
);

CREATE TABLE Horario (
    idHorario INTEGER AUTO_INCREMENT PRIMARY KEY,
    horaDisponivel VARCHAR(45) NOT NULL,
    dataDisponivel VARCHAR(45) NOT NULL,
    disponibilidade TINYINT,
    Unidade_idUnidade INTEGER NOT NULL,
    FOREIGN KEY (Unidade_idUnidade) REFERENCES Unidade(idUnidade)
);

CREATE TABLE Historico (
    idHistorico INTEGER AUTO_INCREMENT PRIMARY KEY,
    dataEvento VARCHAR(45),
    descricao VARCHAR(45),
    status VARCHAR(45),
    Agendamento_idAgendamento INTEGER NOT NULL,
    FOREIGN KEY (Agendamento_idAgendamento) REFERENCES Agendamento(idAgendamento)
);