const form = document.getElementById('completaForm');

function calcola() {
	    let corsiSelez = document.getElementById('corsi-selezionati').innerHTML;
		let accessiSett = document.getElementById('maxAccessiSettimanali').value;
		let prezzo = document.getElementById('prezzo');
		let costoRaw = document.getElementById('costoRaw');
		let durata = document.getElementById('durata').value;

		let accessiCost = 40
		if (accessiSett == "5") accessiCost = 65
		
		let durataMult = 1
		if (durata == 3) durataMult = 2.5
		else if (durata == 6) durataMult = 5
		else if (durata == 12) durataMult = 9
		
		let countCorsiScelti = corsiSelez.split("<br>").length - 1;
		let costoFinale = Number((accessiCost+countCorsiScelti*10)*durataMult).toFixed(0)
		prezzo.innerHTML = "Prezzo: $"+costoFinale
		costoRaw.value = costoFinale
}

calcola()

form.addEventListener('change', function(event) {
    if (event.target.tagName === 'INPUT' || event.target.tagName === 'SELECT') {
       calcola()
    }
});