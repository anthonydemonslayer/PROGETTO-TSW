<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Dashboard Utente</title>
		<%= response.getHeader("Global-CSS") %>
		<link rel='stylesheet' type='text/css' href='css/dashboardUtente-style.css'>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	</head>
	
	<body>
		<%@ include file="navbar.jsp" %>
		
		<spacer></spacer>
		
		<div class="pagina-dashboard-utente">
			<p class="titolo grande">DASHBOARD UTENTE</p>
			
			<div class="info">
				<div>
					<p class="titolo piccolo">INFO ACCOUNT</p>
					<p class="paragrafo grande">
						<bold>Email:</bold> giovanni@gmail.com <br/>
						<bold>Nome:</bold> Giovanni <br/>
						<bold>Cognome:</bold> Brancaccio <br/>
						<bold>Telefono:</bold> 123456789 <br/>
					</p>
				</div>
				
				<div>
					<p class="titolo piccolo">ABBONAMENTO ATTIVO</p>
					<p class="paragrafo grande">
						<bold>Validita:</bold> 26/06/2024 - 26/07/2024 <br/>
						<bold>Max accessi settimanali:</bold> 3 <br/>
						<bold>Corsi scelti:</bold> Yoga, Regolare, Pilates <br/>
						<bold>Costo:</bold> $50 <br/>
					</p>
				</div>
			</div>
			
			<div class="lezioni-prenotate">
				<p class="titolo piccolo">LEZIONI PRENOTATE</p>
				<div class="card-grid">
					<div class="card prenotazione">
						<p class="titolo piccolo" style="min-width: 65%;">1 GEN</p>
						<p><bold>Orario:</bold> 19.30 - 20.30</p>
						<p><bold>Tenuta da:</bold> 19.30 - 20.30</p>
						<p><bold>Iscritti:</bold> 19.30 - 20.30</p>
					</div>
					
					<div class="card prenotazione">
						<span>
							<p class="titolo piccolo" style="min-width: 65%;">2 GEN</p>
						</span>
						<p><bold>Orario:</bold> 19.30 - 20.30</p>
						<p><bold>Tenuta da:</bold> 19.30 - 20.30</p>
						<p><bold>Iscritti:</bold> 19.30 - 20.30</p>
					</div>
					
					<div class="card prenotazione">
						<p class="titolo piccolo" style="min-width: 65%;">3 GEN</p>
						<p><bold>Orario:</bold> 19.30 - 20.30</p>
						<p><bold>Tenuta da:</bold> 19.30 - 20.30</p>
						<p><bold>Iscritti:</bold> 19.30 - 20.30</p>
					</div>
				</div>
			</div>
		</div>
		
	</body>
</html>