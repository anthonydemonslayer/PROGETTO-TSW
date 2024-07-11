<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>Carrello</title>
		<%= response.getHeader("Global-CSS") %>
		<link rel='stylesheet' type='text/css' href='css/carrello-style.css'>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	</head>

	<body>	
		<%@ include file="navbar.jsp" %>
		
		<spacer></spacer>

		<p class="titolo grande" style="min-width: 100%; text-align: center; padding-top: 5vh;">Carrello</p>
		
		<div class="pagina-carrello">
			<div class="elenco-prodotti">
				<div class="prodotto">
					<div class="info">
						<p class="paragrafo grande">ABBONAMENTO</p>
						<p>
							<bold>Durata:</bold> 1 mese <br/>
							<bold>Max accessi settimanali:</bold> 3 <br/>
							<bold>Corsi scelti:</bold> Yoga, Regolare, Pilates <br/>
						</p>
					</div>
					<p class="paragrafo grande">$50</p>
					
					<button class="contieni-immagine vuoto">
						<img alt="" src="images/cancellaProdotto.png">
					</button>
				</div>
				
				<separator></separator>
				
				<div class="prodotto">
					<div class="info">
						<p class="paragrafo grande">LEZIONE YOGA, 1/01/2024</p>
						<p><bold>Orario:</bold> 19.30 - 20.30</p>
					</div>
					
					<p class="paragrafo grande">$50</p>
					
					<button class="contieni-immagine vuoto">
						<img alt="" src="images/cancellaProdotto.png">
					</button>
				</div>
				
				<separator></separator>
				
				<div class="prodotto">
					<div class="info">
						<p class="paragrafo grande">LEZIONE YOGA, 2/01/2024</p>
						<p><bold>Orario:</bold> 19.30 - 20.30</p>
					</div>
					
					<p class="paragrafo grande">$50</p>
					
					<button class="contieni-immagine vuoto">
						<img alt="" src="images/cancellaProdotto.png">
					</button>
				</div>
			</div>
			
			<div class="totale">
				<div>
				<p class="paragrafo-grande"><bold>Subtotale:</bold> $75</p>
				<p class="paragrafo-grande"><bold>IVA:</bold> $16.50</p>
				<p class="titolo piccolo">TOTALE: $91.50</p>
				</div>
				<span style="gap: 10px;">
					<button class="cta" id="acquistaBtn">ACQUISTA</button>
					<button class="contieni-immagine">
						<img alt="" src="images/cancellaCarrello.svg">					
					</button>
				</span>
			</div>
		</div>
		
	</body>
</html>