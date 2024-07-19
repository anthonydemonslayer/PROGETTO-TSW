<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>Storico Ordini</title>
		<link rel='stylesheet' type='text/css' href='css/storicoOrdini-style.css'>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	</head>

	<body>	
		<%@ include file="navbar.jsp" %>

		<spacer></spacer>

		<div class="pagina-storico-ordini">
			<%@ include file="navbarAdmin.jsp" %>
			
			<form>
				<span style="flex-wrap: wrap;">
					<div class="textbox">
						<p><bold>Da</bold></p>
						<div class="date-wrapper">
							<input type="date" id="periodoDa" required></input>
						</div>
					</div>
					
					<div class="textbox">
						<p><bold>A</bold></p>
						<div class="date-wrapper">
							<input type="date" id="periodoA" required></input>
						</div>
					</div>
				</span>
			</form>
			
			<div class="card-grid">
				<div class="card prenotazione">
					<p class="titolo piccolo" style="min-width: 65%;">LEZ. YOGA</p>
					<p><bold>Ordinato da:</bold> Giovanni Brancaccio</p>
					<p><bold>Importo:</bold> $15</p>
					<p><bold>Orario:</bold> 19.30 - 20.30</p>
				</div>
				
				<div class="card prenotazione">
					<p class="titolo piccolo" style="min-width: 65%;">LEZ. PILATES</p>
					<p><bold>Ordinato da:</bold> Giovanni Brancaccio</p>
					<p><bold>Importo:</bold> $15</p>
					<p><bold>Orario:</bold> 19.30 - 20.30</p>
				</div>
				
				<div class="card prenotazione">
					<p class="titolo piccolo" style="min-width: 65%;">ABBON.</p>
					<p><bold>Creato da:</bold> Giovanni Brancaccio</p>
					<p><bold>Importo:</bold> $15</p>
					<p><bold>Corsi:</bold> Yoga, Regolare, Pilates</p>
				</div>
			</div>
		</div>
	</body>
</html>