<%@page import="model.abbonamento.*"%>
<%@ page import="model.utente.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% UtenteBean utente_ = (UtenteBean) request.getSession().getAttribute("utente"); %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Dashboard Utente</title>
		<%= response.getHeader("Global-CSS") %>
		<link rel="stylesheet" type="text/css" href="/FitFusion/css/dashboardUtente-style.css">
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	</head>
	
	<body>
		<% 
		Boolean embed = (request.getParameter("embed") != null) ? request.getParameter("embed").equals("true") : false;
		if (embed == false) {
		%>
		<%@ include file="navbar.jsp" %>
		<spacer></spacer>
		<% } %>
		
		
		<div class="pagina-dashboard-utente">
		
			<% 
			if (embed == false) {
			%>
			<p class="titolo grande">DASHBOARD UTENTE</p>
			<% } %>
			
			<div class="info">
				<div>
					<p class="titolo piccolo">INFO ACCOUNT</p>
					<p class="paragrafo grande">
						<bold>Email:</bold> <%= utente_.getIndirizzo() %> <br/>
						<bold>Nome:</bold> <%= utente_.getNomeUtente() %> <br/>
						<bold>Cognome:</bold> <%= utente_.getCognome() %> <br/>
						<bold>Telefono:</bold> <%= utente_.getTelefono().toString() %> <br/>
						<bold>Tipo account:</bold> <%= utente_.getTipoUtente().toString() %> <br/>
					</p>
				</div>
				
				<%
				AbbonamentoBean abb = (new AbbonamentoDAO()).doRetreiveByKey(utente_.getIdUtente());
				if (abb != null) {
				%>
				<div>
					<p class="titolo piccolo">ABBONAMENTO ATTIVO</p>
					<p class="paragrafo grande">
						<bold>Validita:</bold> <%= abb.getDataAcquisto().toString() %> - <%= abb.getDataAcquisto().plusMonths(abb.getDurata()) %> <br/>
						<bold>Max accessi settimanali:</bold> <%= abb.getMaxAccessiSettimanali() %> <br/>
						<bold>Corsi scelti:</bold> Yoga, Regolare, Pilates <br/>
						<bold>Costo:</bold> $<%= abb.getCosto() %> <br/>
					</p>
				</div>
			</div>
			<% } %>
			
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