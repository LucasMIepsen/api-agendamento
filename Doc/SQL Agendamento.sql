CREATE TABLE servico(
id_servico INTEGER AUTO_INCREMENT  NOT NULL,
nome VARCHAR(45) NOT NULL,
area VARCHAR(45) NOT NULL,
descricao VARCHAR(100) NOT NULL,
PRIMARY KEY (id_servico)
);

CREATE TABLE unidade(
id_unidade INTEGER AUTO_INCREMENT NOT NULL,
nome VARCHAR(45) NOT NULL,
endereco VARCHAR(100) NOT NULL,
PRIMARY KEY (id_unidade)
);

CREATE TABLE agendamento(
id_agendamento INTEGER AUTO_INCREMENT,
id_servico INTEGER,
id_unidade INTEGER,
protocolo VARCHAR(45),
data_hora DATETIME,
descricao VARCHAR(100),
status VARCHAR(50) NOT NULL,
PRIMARY KEY (id_agendamento),
FOREIGN KEY (id_servico) REFERENCES servico(id_servico),
FOREIGN KEY (id_unidade) REFERENCES unidade(id_unidade)
);