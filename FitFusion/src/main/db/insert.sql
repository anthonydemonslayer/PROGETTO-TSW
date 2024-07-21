USE Palestra;

INSERT INTO Utente (nomeUtente, cognome, telefono, password, indirizzo) VALUES 
	('Utente1', 'Cognome1', '1234567890', 'password1', 'utente1@example.com'),
    ('Utente3', 'Cognome3', '2345678901', 'password3', 'utente3@example.com'),
    ('Utente5', 'Cognome5', '4567890123', 'password5', 'utente5@example.com'),
    ('Utente7', 'Cognome7', '6789012345', 'password7', 'utente7@example.com'),
    ('Utente9', 'Cognome9', '8901234567', 'password9', 'utente9@example.com');
    
INSERT INTO Utente (nomeUtente, cognome, telefono, password, indirizzo, tipoUtente) VALUES
	('Istruttore1', 'Cognome2', '0987654321', 'password2', 'istruttore1@example.com', "istruttore"),
    ('Istruttore2', 'Cognome4', '3456789012', 'password4', 'istruttore2@example.com', "istruttore"),
    ('Istruttore3', 'Cognome6', '5678901234', 'password6', 'istruttore3@example.com', "istruttore"),
    ('Istruttore4', 'Cognome8', '7890123456', 'password8', 'istruttore4@example.com', "istruttore"),
    ('Istruttore5', 'Cognome10', '9012345678', 'password10', 'istruttore5@example.com', "istruttore"),
    ('admin', '', '', 'admin', 'admin@admin.com', "amministratore");

INSERT INTO Corso (nomeCorso, descrizione) VALUES
	('Yoga', 'Un corso di yoga completo che include posture, tecniche di respiro, rilassamento e meditazione, adatto a tutti i livelli.'),
    ('Regolare', 'L&rsquo;accesso regolare alla palestra: possibilit&agrave; di frequentare ed utilizzare tutti gli attrezzi della sala attrezzi.<br/>'),
    ('Taekwondo', "Un&rsquo;arte marziale caratterizzato da potenti tecniche di calcio. Combina difesa personale, competizione sportiva e disciplina mentale.");
    
INSERT INTO Lezione (dataOra, costo, durata, idUtente, nomeCorso) VALUES
('2024-02-01 10:00:00', 10, 60, 1, 'Regolare'), ('2024-02-02 10:00:00', 10, 60, 2, 'Yoga'),
('2024-02-03 10:00:00', 15, 60, 3, 'Regolare'), ('2024-02-04 10:00:00', 10, 60, 4, 'Taekwondo'),
('2024-02-05 10:00:00', 10, 60, 5, 'Yoga'), ('2024-02-06 10:00:00', 10, 60, 6, 'Regolare'),
('2024-02-07 10:00:00', 10, 60, 7, 'Yoga'), ('2024-02-08 10:00:00', 5, 60, 8, 'Regolare'),
('2024-02-09 10:00:00', 10, 60, 9, 'Regolare'), ('2024-02-10 10:00:00', 15, 60, 10, 'Taekwondo');

INSERT INTO Prenota (idUtente, idLezione) VALUES (1, 1), (2, 2), (3, 3), (4, 4), (5, 5), (6, 6), (7, 7), (8, 8), (9, 9), (10, 10);
INSERT INTO Abbonamento (costo, dataAcquisto, durata, maxAccessiSettimanali, idUtente) VALUES (50.00, '2024-01-01', 3, 3, 1), (50.00, '2024-01-02', 3, 3, 2), (75.00, '2024-01-03', 3, 5, 3), (50.00, '2024-01-04', 3, 3, 4), (100.00, '2024-01-05', 6, 5, 5);
INSERT INTO Include (idAbbonamento, nomeCorso) VALUES (1, 'Regolare'), (2, 'Yoga'), (3, 'Taekwondo'), (4, 'Taekwondo'), (5, 'Regolare');