<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>Carrello</title>
		<%= response.getHeader("Global-CSS") %>
		<link rel='stylesheet' type='text/css' href='css/completaAbbonamento-style.css'>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	</head>

	<body>	
		<%@ include file="navbar.jsp" %>
		
		<spacer></spacer>

		<div class="pagina-completa-abbonamento">
			<p class="titolo grande">COMPLETA ABBONAMENTO</p>
			
			<div class="attributi">
				<div class="attributo">
					<p><bold>Durata</bold></p>
					<div class="custom-select">
						<select>
							<option>1 mese</option>
							<option>3 mesi</option>
							<option>6 mesi</option>
							<option>12 mesi</option>
						</select>
					</div>
				</div>
				
				<div class="attributo">
					<p><bold>Max Accessi Settimanali</bold></p>
					<div class="custom-select">
						<select>
							<option>3</option>
							<option>5</option>
						</select>
					</div>
				</div>
				
				<div class="attributo">
					<p><bold>Corsi Scelti</bold></p>
					<p>
						Yoga <br/>
						Regolare <br/>
						Pilates <br/>
					</p>
				</div>
			</div>
			
			<span style="justify-content: center; gap: 30px;">
				<p class="paragrafo grande"><bold>Prezzo: $50</bold></p>
				<button class="cta">METTI NEL CARRELLO</button>
			</span>
		
	</body>
</html>