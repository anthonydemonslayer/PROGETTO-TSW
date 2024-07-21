<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>Gestisci Utenti</title>
		<link rel='stylesheet' type='text/css' href='css/gestisciUtenti-style.css'>
		<script src="js/gestisciUtenti.js" defer></script>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	</head>

	<body>	
		<%@ include file="navbar.jsp" %>

		<spacer></spacer>

		<div class="pagina-gestisci-utenti">
			<%@ include file="navbarAdmin.jsp" %>
		
			<div class="textbox">
				<p>Cognome Utente</p>
				<span>
					<input type="text" id="cognome" name="cognome" required autofocus></input>
					<button type="button" id="cerca" class="primario" onclick="cercaUtenti()">CERCA</button>
				</span>
			</div>
			<div class="utente">
				<div class="custom-select">
					<select id="utenti">
					</select>
				</div>
				
				<input type="hidden" name="utenteID" id="utenteID" value=""/>
				
				<div class="custom-select" hidden=true>
					<select id="tipoUtente">
						<option>Utente</option>
						<option>Istruttore</option>
						<option>Amministratore</option>
					</select>
				</div>
			</div>
			
			<jsp:include page="dashboardUtente.jsp">
			   <jsp:param name="embed" value="true" />
			</jsp:include> 
		</div>
	</body>
</html>