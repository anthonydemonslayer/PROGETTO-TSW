<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Regolare</title>
		<%= response.getHeader("Global-CSS") %>
		<link rel='stylesheet' type='text/css' href='css/dettagliCorso-style.css'>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	</head>
	
	<body>
		<%@ include file="navbar.jsp" %>
	
		<div class="pagina-dettagli-corso">
			<p class="titolo grande">INFO CORSO</p>
			
			<span class="info-corso">
				<img alt="" src="images/regolare.png"/>
				<div class="descrizione">
					<p class="titolo piccolo">REGOLARE</p>
					<p class="paragrafo grande">L&rsquo;accesso regolare alla palestra: possibilit&agrave; di frequentare ed utilizzare tutti gli attrezzi della sala attrezzi.</p>
				</div>
			</span>
			
			
			<spacer></spacer>
			
			<span style="justify-content: flex-start; gap: 20px;">
				<p class="titolo grande">LEZIONI</p>
				<button id="aggiungiAlCarrello" disabled class="cta">AGGIUNGI AL CARRELLO</button>
			</span>
	
			<p class="paragrafo grande">Spunta le lezioni che vuoi aggiungere al carrello.</p>
			
			<div class="card-grid">
				<div class="card prenotazione">
					<span>
						<p class="titolo piccolo" style="min-width: 65%;">1 GEN</p>
						<div class="checkbox-wrapper">
							<label> <input type="checkbox" /> <span class="checkbox"></span> </label>
						</div>
					</span>
					<p><bold>Orario:</bold> 19.30 - 20.30</p>
					<p><bold>Tenuta da:</bold> 19.30 - 20.30</p>
					<p><bold>Iscritti:</bold> 19.30 - 20.30</p>
				</div>
				
				<div class="card prenotazione">
					<span>
						<p class="titolo piccolo" style="min-width: 65%;">2 GEN</p>
						<div class="checkbox-wrapper">
							<label> <input type="checkbox" /> <span class="checkbox"></span> </label>
						</div>
					</span>
					<p><bold>Orario:</bold> 19.30 - 20.30</p>
					<p><bold>Tenuta da:</bold> 19.30 - 20.30</p>
					<p><bold>Iscritti:</bold> 19.30 - 20.30</p>
				</div>
				
				<div class="card prenotazione">
					<span>
						<p class="titolo piccolo" style="min-width: 65%;">3 GEN</p>
						<div class="checkbox-wrapper">
							<label> <input type="checkbox" /> <span class="checkbox"></span> </label>
						</div>
					</span>
					<p><bold>Orario:</bold> 19.30 - 20.30</p>
					<p><bold>Tenuta da:</bold> 19.30 - 20.30</p>
					<p><bold>Iscritti:</bold> 19.30 - 20.30</p>
				</div>
			</div>
		</div>
	</body>
</html>