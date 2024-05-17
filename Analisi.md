# Analisi per la Progettazione del Sito Web della Palestra

### Obiettivo
Creare un sito web per la gestione degli iscritti di una palestra moderna di medie dimensioni, che offra un'esperienza utente ottimale e faciliti l'organizzazione delle attività e dei corsi offerti. Il sito dovrà permettere agli utenti di prenotare lezioni, acquistare abbonamenti e gestire il proprio profilo in modo semplice e intuitivo. Inoltre, il sito dovrà essere uno strumento efficace per la palestra per monitorare le prenotazioni, gestire gli istruttori e i corsi, e promuovere le proprie attività.

## Fase 1: Analisi delle Specifiche del Progetto

**Funzionalità Chiave**:
- Registrazione e gestione degli utenti (iscritti, istruttori e amministratori).
- Prenotazione e gestione delle lezioni.
- Acquisto e gestione degli abbonamenti.
- Visualizzazione e gestione dei corsi.
- Funzionalità amministrative per la gestione della palestra.

## Fase 2: Identificazione delle Pagine Necessarie

**Pagine Pubbliche**:
1. **Home Page**: Introduzione alla palestra, servizi offerti, CTA per acquisto lezioni e abbonamenti. Collegamenti a: Pagina di Registrazione, Pagina di Login, Catalogo Corsi, Contatti.
2. **Pagina di Registrazione**: Modulo per la creazione di un nuovo account utente. Collegamento alla pagina precedente.
3. **Pagina di Login**: Modulo per l'accesso degli utenti registrati. Collegamento alla pagina precedente.
4. **Catalogo Corsi**: Elenco dei corsi offerti dalla palestra, con possibilità di filtrare e cercare. Include anche l'opzione per acquistare singoli accessi in palestra, rappresentata da un corso chiamato "Accesso Regolare". Collegamenti a: Dettaglio Corso.
5. **Pagina di Creazione Abbonamento**: Modulo per creare il proprio abbonamento, selezionando i corsi e la frequenza desiderati.
6. **Dettaglio Corso**: Informazioni dettagliate su un singolo corso, inclusi istruttore, orari e descrizione. Pulsanti per aggiungere lezioni al carrello. Collegamento a: Catalogo Corsi.
7. **Contatti**: Informazioni di contatto della palestra.
8. **Carrello**: Carrello delle lezioni da acquistare

**Pagine per Utenti Registrati**:
1. **Dashboard Utente**: Panoramica delle attività dell'utente, inclusi corsi prenotati e abbonamenti attivi. Visualizzazione e gestione dell'abbonamento attivo dell'utente. Collegamenti a: Profilo Utente, Storico Prenotazioni.
2. **Profilo Utente**: Gestione delle informazioni personali e delle preferenze dell'utente. Collegamento a: Dashboard Utente.
3. **Storico Prenotazioni**: Elenco delle lezioni prenotate e frequentate dall'utente. Collegamento a: Dashboard Utente.

**Pagine Amministrative**:
1. **Dashboard Amministratore**: Panoramica delle attività amministrative, inclusi report e statistiche. Collegamenti a: Gestione Utenti, Gestione Corsi, Gestione Lezioni, Gestione Abbonamenti, Gestione Prenotazioni, Statistiche e Report.
2. **Gestione Utenti**: Aggiunta, modifica e eliminazione di utenti (iscritti e istruttori). Collegamento a: Dashboard Amministratore.
3. **Gestione Corsi**: Aggiunta, modifica e eliminazione di corsi. Collegamento a: Dashboard Amministratore.
4. **Gestione Lezioni**: Aggiunta, modifica e eliminazione di lezioni. Collegamento a: Dashboard Amministratore.
5. **Gestione Abbonamenti**: Visualizzazione e gestione degli abbonamenti degli utenti. Collegamento a: Dashboard Amministratore.
6. **Gestione Prenotazioni**: Aggiunta, modifica e eliminazione di prenotazioni di lezioni per gli utenti. Collegamento a: Dashboard Amministratore.
7. **Statistiche e Report**: Monitoraggio delle statistiche di frequenza e delle performance dei corsi. Collegamento a: Dashboard Amministratore.

## Fase 3: Creazione della Mappa Navigazionale

**Mappa Navigazionale delle Pagine**:

**Pagine Pubbliche**:
1. **Home Page**
   - Introduzione alla palestra, servizi offerti, CTA per acquisto lezioni e abbonamenti.
   - La CTA di acquisto abbonamento porterà alla Pagina di Creazione Abbonamento.
   - La pagina Catalogo Corsi sarà integrata alla home page, con una griglia di "card" cliccabili che porteranno a Dettaglio Corso.
   - Collegamenti a: Pagina di Registrazione, Pagina di Login, Pagina di Creazione Abbonamento, Dettaglio Corso, Contatti.

2. **Pagina di Registrazione**
   - Modulo per la creazione di un nuovo account utente.
   - Collegamento alla pagina precedente.

3. **Pagina di Login**
   - Modulo per l'accesso degli utenti registrati.
   - Collegamento alla pagina precedente.

4. **Catalogo Corsi**
   - Include anche l'opzione per acquistare singoli accessi in palestra, ovvero il corso "Accesso Regolare".
   - Collegamenti a: Dettaglio Corso.

5. **Dettaglio Corso**
   - Informazioni dettagliate su un singolo corso, inclusi istruttore, orari e descrizione.
   - Pulsanti per quantificare le lezioni che si vogliono acquistare, aggiungerle al carrello o pagare subito.
   - Collegamento a: Catalogo Corsi.

6. **Contatti**
   - Informazioni di contatto della palestra.

**Pagine per Utenti Registrati**:
1. **Dashboard Utente**
   - Panoramica delle attività dell'utente, inclusi corsi prenotati e dettagli abbonamento attivo.
   - Collegamenti a: Profilo Utente, Storico Prenotazioni.

2. **Profilo Utente**
   - Gestione delle informazioni personali e delle preferenze dell'utente.
   - Collegamento a: Dashboard Utente.

3. **Storico Prenotazioni**
   - Elenco delle lezioni prenotate e frequentate dall'utente.
   - Collegamento a: Dashboard Utente.

**Pagine Amministrative**:
1. **Dashboard Amministratore**
   - Panoramica delle attività amministrative, inclusi report e statistiche.
   - Collegamenti a: Gestione Utenti, Gestione Corsi, Gestione Lezioni, Gestione Abbonamenti (Admin), Gestione Prenotazioni, Statistiche e Report.

2. **Gestione Utenti**
   - Aggiunta, modifica e eliminazione di utenti (iscritti e istruttori).
   - Collegamento a: Dashboard Amministratore.

3. **Gestione Corsi**
   - Aggiunta, modifica e eliminazione di corsi.
   - Collegamento a: Dashboard Amministratore.

4. **Gestione Lezioni**
   - Aggiunta, modifica e eliminazione di lezioni.
   - Collegamento a: Dashboard Amministratore.

5. **Gestione Abbonamenti (Admin)**
   - Visualizzazione e gestione degli abbonamenti degli utenti.
   - Collegamento a: Dashboard Amministratore.

6. **Gestione Prenotazioni**
   - Aggiunta, modifica e eliminazione di prenotazioni di lezioni per gli utenti.
   - Collegamento a: Dashboard Amministratore.

7. **Statistiche e Report**
   - Monitoraggio delle statistiche di frequenza e delle performance dei corsi.
   - Collegamento a: Dashboard Amministratore.

**Barra di Navigazione**:
Ogni pagina del sito conterrà una barra di navigazione che permetterà agli utenti di tornare alla home, accedere/registrarsi, entrare nella dashboard utente e accedere al carrello.


# Considerazini varie

1. L'utente deve sempre poter mettere oggetti nel carrello e leggere il prezzo di ciò che sta per acquistare, anche prima di autenticarsi. Quindi potrebbe essere una buona idea implementare un filtro servlet che controlli se l'utente sta per fare un acquisto, e se è quello il caso e non è autenticato lo rimanda alla pagina d'autenticazione. Una volta effettuata l'autenticazione, torna indietro alla pagina sulla quale stava effettuando l'acquisto (il che fa intuire che quando viene aperta la jsp d'accesso questa deve tener traccia della pagina precedente, se esiste, e riportarvici finito l'accesso. Se non esiste può riportare alla home).


# Todo
- mappa navigazionale grafica
- progettazione visiva del front-end
- definizione delle servlet e delle jsp necessarie
- implementazione e modifica del database in modo da supportare il carrello, gli utenti amministratori e rendere l'attributo "email" non multiplo per questione di semplicità