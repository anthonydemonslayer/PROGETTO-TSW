<%@page import="model.corso.CorsoBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>Gestisci Lezioni</title>
		<link rel='stylesheet' type='text/css' href='css/gestisciLezioni-style.css'>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	</head>

	<body>	
		<%@ include file="navbar.jsp" %>

		<spacer></spacer>

		<div class="pagina-gestisci-lezioni">
			<%@ include file="navbarAdmin.jsp" %>
			
			<div class="forms">
				<form action="AggiungiLezione" method="POST">
					<p class="titolo grande">AGGIUNGI LEZIONE</p>
				
					<div class="textbox">
						<p>Orario</p>
						<div class="datetime-wrapper">
							<input type="datetime-local" id="orario" name="dataOra" required></input>
						</div>
					</div>
					
					<div class="textbox">
						<p>Corso</p>
						<div class="custom-select">
							<select name="corso" id="corso" class="corso">
								<%
								List<CorsoBean> corsi = (List<CorsoBean>) request.getAttribute("corsi");
								if (corsi != null && !corsi.isEmpty())
								for (CorsoBean c : corsi) {
								%>
								<option><%= c.getNomeCorso() %></option>
								<% } %>
							</select>
						</div>
					</div>
					
					<div class="textbox">
						<p>Istruttore</p>
						<div class="custom-select">
							<select name="istruttore" id="istruttore">
								<%
								List<UtenteBean> istruttori = (List<UtenteBean>) request.getAttribute("istruttori");
								if (istruttori != null && !istruttori.isEmpty())
								for (UtenteBean i : istruttori) {
								%>
								<option><%= i.getIdUtente() %>: <%= i.getNomeUtente() %> <%= i.getCognome() %></option>
								<% } %>
							</select>
						</div>
					</div>
					
					<div class="textbox">
						<p>Costo</p>
						<input type="number" name="costo" required autofocus></input>
					</div>
					
					<div class="textbox">
						<p>Durata in minuti</p>
						<input type="number" name="durata" required autofocus></input>
					</div>
			
					<button type="submit" class="primario">AGGIUNGI LEZIONE</button>
				</form>
				
				
			</div>
		</div>
	</body>
</html>