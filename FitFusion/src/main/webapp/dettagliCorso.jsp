<%@page import="model.lezione.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.corso.*" %>
<%@ page import="java.util.List" %>

<%
CorsoBean corso = (CorsoBean) request.getAttribute("corso");
if (corso==null) response.sendRedirect("home.jsp");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Regolare</title>
		<%= response.getHeader("Global-CSS") %>
		<link rel='stylesheet' type='text/css' href='css/dettagliCorso-style.css'>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<script src="js/dettagliCorso.js" defer></script>
		
	</head>
	
	<body>
		<%@ include file="navbar.jsp" %>
	
		<form action="AggiungiAlCarrello" method="POST" class="pagina-dettagli-corso">
			<p class="titolo grande">INFO CORSO</p>
			
			<span class="info-corso">
				<img alt="" src="images/<%= corso.getNomeCorso() %>.jpg"/>
				<div class="descrizione">
					<p class="titolo piccolo"><%= corso.getNomeCorso() %></p>
					<p class="paragrafo grande"><%= corso.getDescrizione() %></p>
				</div>
			</span>
			
			<spacer></spacer>
			
			<span style="justify-content: flex-start; gap: 15px;">
				<p class="titolo grande">LEZIONI</p>
				<button type="submit" id="aggiungiAlCarrello" disabled class="cta">METTI NEL CARRELLO</button>
			</span>
	
			<p class="paragrafo grande">Spunta le lezioni che vuoi aggiungere al carrello.</p>

			<div class="card-grid">			
				<% 
			    List<LezioneBean> lezioni = (List<LezioneBean>)request.getAttribute("lezioni");
			    if(lezioni != null && !lezioni.isEmpty()) {
		        for(LezioneBean lezione : lezioni) {
			    %>
					<div class="card prenotazione">
						<span>
							<p class="titolo piccolo" style="min-width: 65%;"><%= lezione.getDataOra().getDayOfMonth() +" "+ lezione.getDataOra().getMonth().toString() %></p>
							<div class="checkbox-wrapper">
								<label> <input type="checkbox" class="check" name="lezioni" value="<%= lezione.getIdLezione() %>"/> <span class="checkbox"></span> </label>
							</div>
						</span>
						<p><bold>Orario:</bold> <%= lezione.getDataOra().toLocalTime().toString() %> - <%= lezione.getDataOra().plusMinutes(lezione.getDurata()).toLocalTime().toString() %></p>
						<p><bold>Iscritti:</bold> <%= lezione.getNumIscritti() %></p>
						<p><bold>Costo:</bold> $<%= lezione.getCosto() %> </p>
					</div>
				<% }} %>
			</div>
			
		</form>
	</body>
</html>