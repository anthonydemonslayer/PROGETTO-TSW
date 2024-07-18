USE Palestra;

INSERT INTO Utente (nomeUtente, cognome, telefono, password) VALUES ('Utente1', 'Cognome1', '1234567890', 'password1'), ('Utente3', 'Cognome3', '2345678901', 'password3'), ('Utente5', 'Cognome5', '4567890123', 'password5'), ('Utente7', 'Cognome7', '6789012345', 'password7'), ('Utente9', 'Cognome9', '8901234567', 'password9');
INSERT INTO Utente (nomeUtente, cognome, telefono, password, tipoUtente) VALUES ('Istruttore1', 'Cognome2', '0987654321', 'password2', "istruttore"), ('Istruttore2', 'Cognome4', '3456789012', 'password4', "istruttore"), ('Istruttore3', 'Cognome6', '5678901234', 'password6', "istruttore"), ('Istruttore4', 'Cognome8', '7890123456', 'password8', "istruttore"), ('Istruttore5', 'Cognome10', '9012345678', 'password10', "istruttore");
INSERT INTO Email (indirizzo, idUtente) VALUES ('utente1@example.com', 1), ('utente2@example.com', 2), ('utente3@example.com', 3), ('utente4@example.com', 4), ('utente5@example.com', 5), ('utente6@example.com', 6), ('utente7@example.com', 7), ('utente8@example.com', 8), ('utente9@example.com', 9), ('utente10@example.com', 10);
INSERT INTO Corso (nomeCorso, descrizione) VALUES ('Corso1', 'Descrizione corso 1'), ('Corso2', 'Descrizione corso 2'), ('Corso3', 'Descrizione corso 3');
INSERT INTO Lezione (dataOra, costo, durata, idUtente, nomeCorso) VALUES ('2024-02-01 10:00:00', 10, 60, 1, 'Corso1'), ('2024-02-02 10:00:00', 10, 60, 2, 'Corso2'), ('2024-02-03 10:00:00', 15, 60, 3, 'Corso3'), ('2024-02-04 10:00:00', 10, 60, 4, 'Corso3'), ('2024-02-05 10:00:00', 10, 60, 5, 'Corso2'), ('2024-02-06 10:00:00', 10, 60, 6, 'Corso1'), ('2024-02-07 10:00:00', 10, 60, 7, 'Corso2'), ('2024-02-08 10:00:00', 5, 60, 8, 'Corso3'), ('2024-02-09 10:00:00', 10, 60, 9, 'Corso2'), ('2024-02-10 10:00:00', 15, 60, 10, 'Corso1');
INSERT INTO Prenota (idUtente, idLezione) VALUES (1, 1), (2, 2), (3, 3), (4, 4), (5, 5), (6, 6), (7, 7), (8, 8), (9, 9), (10, 10);
INSERT INTO Abbonamento (costo, dataAcquisto, durata, maxAccessiSettimanali, idUtente) VALUES (50.00, '2024-01-01', 3, 3, 1), (50.00, '2024-01-02', 3, 3, 2), (75.00, '2024-01-03', 3, 5, 3), (50.00, '2024-01-04', 3, 3, 4), (100.00, '2024-01-05', 6, 5, 5);
INSERT INTO Include (idAbbonamento, nomeCorso) VALUES (1, 'Corso1'), (2, 'Corso2'), (3, 'Corso3'), (4, 'Corso1'), (5, 'Corso2');

DELETE FROM Prenota WHERE idUtente = 1 AND idLezione = 1;
SELECT * FROM Lezione WHERE nomeCorso = 'Corso1' ORDER BY dataOra;
SELECT numIscritti FROM Lezione WHERE idLezione = 1;
SELECT * FROM Corso;
SELECT * FROM Utente WHERE nomeUtente = 'Utente1' AND cognome = 'Cognome1';
SELECT Abbonamento.* FROM Abbonamento NATURAL JOIN Utente WHERE Utente.nomeUtente = 'Utente1' AND Utente.cognome = 'Cognome1';
UPDATE Lezione SET dataOra = cast('2024-01-24 15:43:00' as datetime) WHERE idLezione = 1;
SELECT Lezione.* FROM Lezione NATURAL JOIN Utente WHERE Utente.nomeUtente = 'Istruttore1' AND Utente.cognome = 'Cognome1'