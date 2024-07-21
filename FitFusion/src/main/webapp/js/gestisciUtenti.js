const utentiList = document.getElementById("utenti")

function cercaUtenti() {
    var cognome = document.getElementById("cognome").value;
    var tipoUtente = document.getElementById("tipoUtente");

    var xhr = new XMLHttpRequest();
    xhr.open("GET", "CercaUtente?cognome=" + encodeURIComponent(cognome), true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var utenti = JSON.parse(xhr.responseText);
            var output = "";
            utenti.forEach(function(utente) {
                output += "<option> " + utente.id + ": "+ utente.nome + " " + utente.cognome + "</option>";
            });
            
            utentiList.innerHTML = output;

            if (utenti[0]) {
				let utente =  utenti[0]
            	tipoUtente.value = utente.tipo
            	selezionaUtente(utente.id)
            }
            else
            	tipoUtente.value = ""
        }
    };
    xhr.send();
}

utentiList.addEventListener('change', function() {
	let utenteID = utentiList.value.split(":")[0]
	console.log(utenteID)
	selezionaUtente(utenteID)
}, false);


function selezionaUtente(idUtente) {
            var xhr = new XMLHttpRequest();
            xhr.open("GET", "OttieniDettagliUtente?idUtente=" + idUtente, true);
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    var response = JSON.parse(xhr.responseText);
                    var utente = response.utente;
                    var abbonamento = response.abbonamento;
                    var lezioni = response.lezioni;

                    document.getElementById("nomeUtente").innerHTML = utente.nomeUtente
                    document.getElementById("cognome").innerHTML = utente.cognome
                    document.getElementById("indirizzo").innerHTML = utente.indirizzo
                    document.getElementById("telefono").innerHTML = utente.telefono
                    document.getElementById("tipo").innerHTML = utente.tipo

					if (abbonamento != null) {
						document.getElementById("dataAcquisto").innerHTML = abbonamento.dataAcquisto + ", " + abbonamento.durata + " mesi"
	                    document.getElementById("costo").innerHTML = "$"+abbonamento.costo
	                    document.getElementById("corsiScelti").hidden = true
	                    document.getElementById("maxAccessiSettimanali").innerHTML = abbonamento.maxAccessiSettimanali
					} else {
						document.getElementById("dataAcquisto").innerHTML = "-"
	                    document.getElementById("costo").innerHTML = "-"
	                    document.getElementById("corsiScelti").hidden = true
	                    document.getElementById("maxAccessiSettimanali").innerHTML = "-"
					}
					
                    var lezioniOutput = "";
                    lezioni.forEach(function(lezione) {
					lezioniOutput += `
						<div class="card prenotazione">
							<p class="titolo piccolo" style="min-width: 65%;"> LEZIONE </p>
							<p><bold>Data Ora:</bold> ` + lezione.dataOra + `  </p>
							<p><bold>Corso:</bold> ` + lezione.nomeCorso + ` </p>
							<p><bold>Costo:</bold> ` + lezione.costo + ` </p>
						</div>
					`
                    });
                    document.getElementById("lezioni").innerHTML = lezioniOutput;
                }
            };
            xhr.send();
        }