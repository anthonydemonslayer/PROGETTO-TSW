# Progetto TSW - E-Commerce Fit Fusion

=> [Link all'anteprima della progettazione grafica](https://www.figma.com/design/CHrcX4ax4iAVqRa2slupEV/%5BTSW%5D-Palestra?node-id=256-601&t=qWwZtXca4Yn5eSng-1)

## Struttura Java EE con Tomcat

- **`src/main/java/`**: Contiene tutto il codice sorgente Java dell'applicazione.
   - **`model/`**: Classi che rappresentano il modello dei dati.
   - **`dao/`**: Classi per l'accesso ai dati (Data Access Objects).
   - **`service/`**: Classi che implementano la logica di business.
   - **`control/`**: Servlet che fungono da controller.

- **`src/main/webapp/`**: Contiene i file web dell'applicazione.
	- **`WEB-INF/`**: Cartella per file di configurazione e risorse non accessibili direttamente.
		- **`web.xml`**: File di configurazione principale dell'applicazione web.
	- **`META-INF/`**: Per metadati dell'applicazione web.
	- **`css/`**: File CSS per lo stile delle pagine web.
	- **`js/`**: File JavaScript per la funzionalità client-side.
	- **`images/`**: Immagini e altri file multimediali.
	- **`html/`**: Pagine HTML statiche (se presenti).
	- **`index.jsp`**: Le varie pagine jsp dell'applicazione web.

- **`src/main/db/`**: Contiene i file SQL del database.
   
### Vantaggi di questa struttura:

- Separa chiaramente il codice Java dai file web.
- Organizza il codice in package logici (model, dao, service, servlet) per una migliore manutenibilità.
- È compatibile con Eclipse e altri IDE comuni.
- Segue una struttura standard riconoscibile per progetti Java EE.
- Permette una facile espansione futura del progetto.
