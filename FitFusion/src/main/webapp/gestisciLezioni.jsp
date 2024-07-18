<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>Gestisci Lezioni</title>
		<link rel='stylesheet' type='text/css' href='css/gestisciCorsi-style.css'>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	</head>

	<body>	
		<%@ include file="navbar.jsp" %>

		<spacer></spacer>

		<div class="pagina-gestisci-corsi">
			<%@ include file="navbarAdmin.jsp" %>
			
			<div class="forms">
				<form action="/autenticazione" method="post">
					<p class="titolo grande">MODIFICA LEZIONE</p>
				
					<div class="custom-select">
						<select id="lezione">
							<option>6/01/2025, Yoga, 7:30</option>
							<option>6/02/2025, Pilates, 5:30</option>
							<option>...</option>
						</select>
					</div>
					
					<div class="textbox">
						<p>Orario</p>
						<div class="datetime-wrapper">
							<input type="datetime-local" id="orario" required></input>
						</div>
					</div>
					
					<div class="textbox">
						<p>Corso</p>
						<div class="custom-select">
							<select id="corso">
								<option>Yoga</option>
								<option>Pilates</option>
								<option>...</option>
							</select>
						</div>
					</div>
					
					<div class="textbox">
						<p>Istruttore</p>
						<div class="custom-select">
							<select id="istruttore">
								<option>Mariasofia Rossonissima</option>
								<option>Giovanni Brancaccio</option>
								<option>...</option>
							</select>
						</div>
					</div>
					
					<button type="submit" class="primario">APPLICA MODIFICHE</button>
				</form>
				
				<form action="/autenticazione" method="post">
					<p class="titolo grande">AGGIUNGI LEZIONE</p>
				
					<div class="textbox">
						<p>Orario</p>
						<div class="datetime-wrapper">
							<input type="datetime-local" id="orario" required></input>
						</div>
					</div>
					
					<div class="textbox">
						<p>Corso</p>
						<div class="custom-select">
							<select id="corso">
								<option>Yoga</option>
								<option>Pilates</option>
								<option>...</option>
							</select>
						</div>
					</div>
					
					<div class="textbox">
						<p>Istruttore</p>
						<div class="custom-select">
							<select id="istruttore">
								<option>Mariasofia Rossonissima</option>
								<option>Giovanni Brancaccio</option>
								<option>...</option>
							</select>
						</div>
					</div>
					
					<div class="textbox">
						<p>Costo</p>
						<input type="number" name="costo" required autofocus></input>
					</div>
			
					<button type="submit" class="primario">AGGIUNGI CORSO</button>
				</form>
				
				
			</div>
		</div>
	</body>
</html>