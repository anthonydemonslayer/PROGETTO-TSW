<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>Carrello</title>
		<%= response.getHeader("Global-CSS") %>
		<link rel='stylesheet' type='text/css' href='css/completaAbbonamento-style.css'>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<script src="js/completaAbbonamento.js" defer></script>
		
	</head>

	<body>	
		<%@ include file="navbar.jsp" %>
		
		<spacer></spacer>

		<form action="CompletaAbbonamento" method="POST" id="completaForm" style="">
			<div class="pagina-completa-abbonamento">
				<p class="titolo grande">COMPLETA ABBONAMENTO</p>
				
				<div class="attributi">
					<div class="attributo">
						<p><bold>Durata in mesi</bold></p>
						<div class="custom-select">
							<select name="durata" id="durata">
								<option>1</option>
								<option>3</option>
								<option>6</option>
								<option>12</option>
							</select>
						</div>
					</div>
					
					<div class="attributo">
						<p><bold>Max Accessi Settimanali</bold></p>
						<div class="custom-select">
							<select name="maxAccessiSettimanali" id="maxAccessiSettimanali">
								<option>3</option>
								<option>5</option>
							</select>
						</div>
					</div>
					
					<div class="attributo">
						<p><bold>Corsi Scelti</bold></p>
						<%
						String[] corsi = request.getParameterValues("corsi");
						%>
						<p id="corsi-selezionati" value="<%= corsi.length %>">
							<% for (String c : corsi) { %>
								<%= c %> <br/>
							<% } %>
						</p>
					</div>
				</div>
			</div>		
				
			<span style="justify-content: center; gap: 30px;">
				<p class="paragrafo grande"><bold id="prezzo">Prezzo: $50</bold></p>
				<button type="submit" class="cta">METTI NEL CARRELLO</button>
			</span>
			
			<input type="hidden" name="costo" id="costoRaw" value="50">
		</form>
	</body>
</html>