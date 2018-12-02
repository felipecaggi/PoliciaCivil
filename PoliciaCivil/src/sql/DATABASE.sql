CREATE DATABASE policia;

DROP SCHEMA IF EXISTS policiaschema CASCADE;
CREATE SCHEMA policiaschema;

SET search_path = 'policiaschema';

DROP TABLE IF EXISTS policiaschema.ocorrencia CASCADE;
DROP TABLE IF EXISTS policiaschema.cidadao CASCADE;
DROP TABLE IF EXISTS policiaschema.policial CASCADE;
DROP TABLE IF EXISTS policiaschema.endereco CASCADE;
DROP TABLE IF EXISTS policiaschema.possuiPais CASCADE;
DROP TABLE IF EXISTS policiaschema.envolvido CASCADE;
DROP TABLE IF EXISTS policiaschema.testemunha CASCADE;
DROP TABLE IF EXISTS policiaschema.vitima CASCADE;
DROP TABLE IF EXISTS policiaschema.autor CASCADE;
DROP TABLE IF EXISTS policiaschema.delegacia CASCADE;
DROP TABLE IF EXISTS policiaschema.delegado CASCADE;
DROP TABLE IF EXISTS policiaschema.mandado CASCADE;
DROP TABLE IF EXISTS policiaschema.evidencia CASCADE;
DROP TABLE IF EXISTS policiaschema.arma CASCADE;
DROP TABLE IF EXISTS policiaschema.veiculo CASCADE;
DROP TABLE IF EXISTS policiaschema.objeto CASCADE;
DROP TABLE IF EXISTS policiaschema.substancia CASCADE;
DROP TABLE IF EXISTS policiaschema.celular CASCADE;
DROP TABLE IF EXISTS policiaschema.evidencia_ocorrencia CASCADE;

CREATE TABLE policiaschema.policial(
idPolicial INT PRIMARY KEY,
nome VARCHAR(80) NOT NULL,
login VARCHAR(20) NOT NULL,
senha VARCHAR(20) NOT NULL,
cargo VARCHAR(80) NOT NULL
);

CREATE TABLE policiaschema.endereco(
idEndereco INT PRIMARY KEY,
cep VARCHAR (8) NOT NULL,
logradouro VARCHAR (80) NOT NULL,
numero INTEGER NOT NULL, 
bairro VARCHAR (80) NOT NULL,
complemento VARCHAR (80),
estado VARCHAR (2) NOT NULL,
cidade VARCHAR (80) NOT NULL
);

CREATE TABLE policiaschema.delegacia(
idDelegacia INT PRIMARY KEY,
nome VARCHAR (50) NOT NULL,
sigla VARCHAR (5) NOT NULL
);

CREATE TABLE policiaschema.delegado(
idPolicial INT PRIMARY KEY,
idDelegacia INT
);

CREATE TABLE policiaschema.ocorrencia(
idOcorrencia INT PRIMARY KEY,
dataOcor datetime NOT NULL,
status VARCHAR (50) NOT NULL,
infracao VARCHAR (50) NOT NULL,
segredoJustica BOOLEAN NOT NULL,
idPolicial INT NOT NULL,
idEndereco INT NOT NULL,
idDelegacia INT NOT NULL,
idDelegado INT NOT NULL,
idComunicante VARCHAR (11) NOT NULL
);

CREATE TABLE policiaschema.cidadao(
cpf VARCHAR (11) PRIMARY KEY,
nome VARCHAR (80) NOT NULL,
dataNasc date NOT NULL,
rg VARCHAR (7) NOT NULL,
telefone INT NOT NULL,
estadoOrigem VARCHAR (2) NOT NULL,
cidadeOrigem VARCHAR (80) NOT NULL,
status VARCHAR (30),
alcunha VARCHAR (30),
idEndereco INT NOT NULL
);

CREATE TABLE policiaschema.possuiPais(
cpf_filho varchar (11),
cpf_pai varchar (11),
PRIMARY KEY(cpf_filho, cpf_pai)
);

CREATE TABLE policiaschema.testemunha(
idOcorrencia INT,
cpfCidadao VARCHAR (11),
PRIMARY KEY(idOcorrencia, cpfCidadao)
);

CREATE TABLE policiaschema.vitima(
idOcorrencia INT,
cpfCidadao VARCHAR (11),
PRIMARY KEY(idOcorrencia, cpfCidadao)
);

CREATE TABLE policiaschema.autor(
idOcorrencia INT,
cpfCidadao VARCHAR (11),
conduzido boolean,
PRIMARY KEY(idOcorrencia, cpfCidadao)	
);

CREATE TABLE policiaschema.envolvido(
idOcorrencia INT,
idPolicial INT,
PRIMARY KEY(idOcorrencia, idPolicial)
);

CREATE TABLE policiaschema.mandado(
idMan INT PRIMARY KEY,
dataExpedicao date NOT NULL,
idDelegado INT NOT NULL,
cpfCidadao VARCHAR (11) NOT NULL
);

CREATE TABLE policiaschema.evidencia(
idEvidencia INT PRIMARY KEY,
providencia VARCHAR (50) NOT NULL,
tipo VARCHAR (50) NOT NULL
);

CREATE TABLE policiaschema.arma(
calibre VARCHAR (5),
numSerie VARCHAR (10),
fabricante VARCHAR (50),
modelo VARCHAR (50),
idEvidencia INT,
PRIMARY KEY(numSerie, calibre, idEvidencia)
);

CREATE TABLE policiaschema.veiculo(
numChassi VARCHAR (17) NOT NULL,
placa VARCHAR (4) NOT NULL,
modelo VARCHAR (30) NOT NULL,
anoFabricacao date NOT NULL,
ano date NOT NULL,
fabricacao VARCHAR (50),
cor VARCHAR (10) NOT NULL,
idEvidencia INT,
PRIMARY KEY(numChassi, placa, idEvidencia)
);

CREATE TABLE policiaschema.Objeto(
nome VARCHAR (50) NOT NULL,
descricao VARCHAR (50),
idEvidencia INT,
PRIMARY KEY(nome, idEvidencia)
);

CREATE TABLE policiaschema.substancia(
tipo VARCHAR (30) NOT NULL,
peso INT NOT NULL,
embalagem VARCHAR (20),
altura INT,
comprimento INT,
largura INT,
qtd INT,
idEvidencia INT,
PRIMARY KEY(tipo, idEvidencia)
);

CREATE TABLE policiaschema.celular(
imei VARCHAR (15) NOT NULL,
numero INT NOT NULL,
fabricacao VARCHAR (50),
modelo VARCHAR (50) NOT NULL,
nome VARCHAR (50) NOT NULL,
cpfProprietario VARCHAR (11) NOT NULL,
nomeProprietario VARCHAR (50) NOT NULL,
idEvidencia INT,
PRIMARY KEY(imei, idEvidencia)
);

CREATE TABLE policiaschema.evidencia_ocorrencia(
idOcorrencia INT,
idEvidencia INT,
PRIMARY KEY(idOcorrencia, idEvidencia)
);

ALTER TABLE ONLY policiaschema.delegado 
	ADD CONSTRAINT delegadoPolicial_fkey FOREIGN KEY (idPolicial) REFERENCES policiaschema.policial(idPolicial);

ALTER TABLE ONLY policiaschema.delegado 
	ADD CONSTRAINT delegadoDelegacia_fkey FOREIGN KEY (idDelegacia) REFERENCES policiaschema.delegacia(idDelegacia);
	
ALTER TABLE ONLY policiaschema.ocorrencia 
	ADD CONSTRAINT ocorrenciaPolicial_fkey FOREIGN KEY (idPolicial) REFERENCES policiaschema.policial(idPolicial);

ALTER TABLE ONLY policiaschema.ocorrencia 
	ADD CONSTRAINT ocorrenciaCidadao_fkey FOREIGN KEY (idComunicante) REFERENCES policiaschema.cidadao(cpf);

ALTER TABLE ONLY policiaschema.ocorrencia 
	ADD CONSTRAINT ocorrenciaEndereco_fkey FOREIGN KEY (idEndereco) REFERENCES policiaschema.endereco(idEndereco);

ALTER TABLE ONLY policiaschema.ocorrencia 
	ADD CONSTRAINT ocorrenciaDelegacia_fkey FOREIGN KEY (idDelegacia) REFERENCES policiaschema.delegacia(idDelegacia);
	
ALTER TABLE ONLY policiaschema.ocorrencia 
	ADD CONSTRAINT ocorrenciaDelegado_fkey FOREIGN KEY (idDelegado) REFERENCES policiaschema.delegado(idPolicial);
	
ALTER TABLE ONLY policiaschema.possuiPais 
	ADD CONSTRAINT possuipaisFilho_fkey FOREIGN KEY (cpf_filho) REFERENCES policiaschema.cidadao(cpf);

ALTER TABLE ONLY policiaschema.possuiPais 
	ADD CONSTRAINT possuipaisPai_fkey FOREIGN KEY (cpf_pai) REFERENCES policiaschema.cidadao(cpf);
	
ALTER TABLE ONLY policiaschema.testemunha
	ADD CONSTRAINT testemunhaOcorrencia_fkey FOREIGN KEY (idOcorrencia) REFERENCES policiaschema.ocorrencia(idOcorrencia);
	
ALTER TABLE ONLY policiaschema.testemunha
	ADD CONSTRAINT testemunhaCidadao_fkey FOREIGN KEY (cpfCidadao) REFERENCES policiaschema.cidadao(cpf);
	
ALTER TABLE ONLY policiaschema.vitima
	ADD CONSTRAINT vitimaOcorrencia_fkey FOREIGN KEY (idOcorrencia) REFERENCES policiaschema.ocorrencia(idOcorrencia);
	
ALTER TABLE ONLY policiaschema.vitima
	ADD CONSTRAINT vitimaCidadao_fkey FOREIGN KEY (cpfCidadao) REFERENCES policiaschema.cidadao(cpf);
	
ALTER TABLE ONLY policiaschema.autor
	ADD CONSTRAINT autorOcorrencia_fkey FOREIGN KEY (idOcorrencia) REFERENCES policiaschema.ocorrencia(idOcorrencia);

ALTER TABLE ONLY policiaschema.autor
	ADD CONSTRAINT autorCidadao_fkey FOREIGN KEY (cpfCidadao) REFERENCES policiaschema.cidadao(cpf);
	

ALTER TABLE ONLY policiaschema.cidadao
	ADD CONSTRAINT cidadaoEndereco_fkey FOREIGN KEY (idEndereco) REFERENCES policiaschema.endereco(idEndereco);
	
ALTER TABLE ONLY policiaschema.envolvido
	ADD CONSTRAINT envolvidoOcorrencia_fkey FOREIGN KEY (idOcorrencia) REFERENCES policiaschema.ocorrencia(idOcorrencia);
	
ALTER TABLE ONLY policiaschema.envolvido
	ADD CONSTRAINT envolvidoPolicial_fkey FOREIGN KEY (idPolicial) REFERENCES policiaschema.policial(idPolicial);

ALTER TABLE ONLY policiaschema.mandado
	ADD CONSTRAINT mandadoDelegado_fkey FOREIGN KEY (idDelegado) REFERENCES policiaschema.delegado(idPolicial);
	
ALTER TABLE ONLY policiaschema.mandado
	ADD CONSTRAINT mandadoCidadao_fkey FOREIGN KEY (cpfCidadao) REFERENCES policiaschema.cidadao(cpf);
	
ALTER TABLE ONLY policiaschema.arma
	ADD CONSTRAINT armaEvidencia_fkey FOREIGN KEY (idEvidencia) REFERENCES policiaschema.evidencia(idEvidencia);

ALTER TABLE ONLY policiaschema.veiculo
	ADD CONSTRAINT veiculoEvidencia_fkey FOREIGN KEY (idEvidencia) REFERENCES policiaschema.evidencia(idEvidencia);
	
ALTER TABLE ONLY policiaschema.objeto
	ADD CONSTRAINT objetoEvidencia_fkey FOREIGN KEY (idEvidencia) REFERENCES policiaschema.evidencia(idEvidencia);
	
ALTER TABLE ONLY policiaschema.substancia
	ADD CONSTRAINT substanciaEvidencia_fkey FOREIGN KEY (idEvidencia) REFERENCES policiaschema.evidencia(idEvidencia);
	
ALTER TABLE ONLY policiaschema.celular
	ADD CONSTRAINT celularEvidencia_fkey FOREIGN KEY (idEvidencia) REFERENCES policiaschema.evidencia(idEvidencia);

ALTER TABLE ONLY policiaschema.evidencia_ocorrencia
	ADD CONSTRAINT OcorrenciaEvidencia_fkey FOREIGN KEY (idOcorrencia) REFERENCES policiaschema.ocorrencia(idOcorrencia);
	
ALTER TABLE ONLY policiaschema.evidencia_ocorrencia
	ADD CONSTRAINT evidencia_ocorrenciaEvidencia_fkey FOREIGN KEY (idEvidencia) REFERENCES policiaschema.evidencia(idEvidencia);