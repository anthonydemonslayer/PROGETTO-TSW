DROP DATABASE IF EXISTS Palestra;
CREATE DATABASE Palestra;
USE Palestra;

DROP USER IF EXISTS 'gymuser'@'localhost';
CREATE USER 'gymuser'@'localhost' IDENTIFIED BY 'gymuser';
GRANT ALL ON Palestra.* TO 'gymuser'@'localhost';

DROP TABLE IF EXISTS Utente;

CREATE TABLE Utente (
	idUtente INT AUTO_INCREMENT PRIMARY KEY,
    nomeUtente VARCHAR(30) NOT NULL,
    cognome VARCHAR(30) NOT NULL,
    telefono VARCHAR(25),
    password VARCHAR(128) NOT NULL,
    tipoUtente VARCHAR(50) DEFAULT "utente"
);

DROP TABLE IF EXISTS Email;

CREATE TABLE Email (
	indirizzo VARCHAR(50) PRIMARY KEY,
	idUtente INT NOT NULL,
	FOREIGN KEY (idUtente) REFERENCES Utente(idUtente)
);

DROP TABLE IF EXISTS Corso;

CREATE TABLE Corso (
	nomeCorso VARCHAR(50) PRIMARY KEY,
	descrizione TEXT
);

DROP TABLE IF EXISTS Lezione;

CREATE TABLE Lezione (
	idLezione INT AUTO_INCREMENT PRIMARY KEY,
	costo DECIMAL(10,2) NOT NULL,
	dataOra DATETIME NOT NULL,
	durata INT NOT NULL,
	numIscritti INT DEFAULT 0,
	idUtente INT NOT NULL,
	nomeCorso VARCHAR(50) NOT NULL,
	FOREIGN KEY (idUtente) REFERENCES Utente(idUtente),
	FOREIGN KEY (nomeCorso) REFERENCES Corso(nomeCorso)
);

DROP TABLE IF EXISTS Prenota;

CREATE TABLE Prenota (
	idUtente INT NOT NULL,
    idLezione INT NOT NULL,
    PRIMARY KEY (idUtente, idLezione),
    FOREIGN KEY (idUtente) REFERENCES Utente(idUtente),
    FOREIGN KEY (idLezione) REFERENCES Lezione(idLezione)
);

DROP TABLE IF EXISTS Abbonamento;

CREATE TABLE Abbonamento (
	idAbbonamento INT AUTO_INCREMENT PRIMARY KEY,
	costo DECIMAL(10,2) NOT NULL,
    dataAcquisto DATE NOT NULL,
	durata INT NOT NULL,
    maxAccessiSettimanali INT DEFAULT 3,
    idUtente INT NOT NULL,
    FOREIGN KEY (idUtente) REFERENCES Utente(idUtente)
);

DROP TABLE IF EXISTS Include;

CREATE TABLE Include (
	idAbbonamento INT NOT NULL,
    nomeCorso VARCHAR(255) NOT NULL,
    PRIMARY KEY (idAbbonamento, nomeCorso),
    FOREIGN KEY (idAbbonamento) REFERENCES Abbonamento(idAbbonamento),
    FOREIGN KEY (nomeCorso) REFERENCES Corso(nomeCorso)
);

#
#DEFINIZIONE TRIGGER
#
DELIMITER //

# INCREMENTA numIscritti QUANDO viene aggiunta una prenotazione

CREATE TRIGGER incrementa_numIscritti
AFTER INSERT ON Prenota
FOR EACH ROW
BEGIN
	UPDATE Lezione
    SET numIscritti = numIscritti + 1
    WHERE idLezione = NEW.idLezione;
END; //

# DECREMENTA numIscritti QUANDO viene rimossa una prenotazione

CREATE TRIGGER decrementa_numIscritti
AFTER DELETE ON Prenota
FOR EACH ROW
BEGIN
	UPDATE Lezione
    SET numIscritti = numIscritti - 1
    WHERE idLezione = OLD.idLezione;
END; //

DELIMITER ;
