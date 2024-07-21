<%@page import="model.include.IncludeDAO"%>
<%@page import="model.corso.CorsoDAO"%>
<%@page import="model.corso.CorsoBean"%>
<%@page import="model.abbonamento.*"%>
<%@ page import="model.utente.*" %>
<%@ page import="model.prenota.*" %>
<%@ page import="model.lezione.*" %>
<%@ page import="java.util.List" %>

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
						<bold>Email:</bold> <placeholder id="indirizzo"><%= utente_.getIndirizzo() %> </placeholder> <br/>
						<bold>Nome:</bold> <placeholder id="nomeUtente"><%= utente_.getNomeUtente() %> </placeholder> <br/>
						<bold>Cognome:</bold> <placeholder id="cognome"><%= utente_.getCognome() %> </placeholder> <br/>
						<bold>Telefono:</bold> <placeholder id="telefono"><%= utente_.getTelefono().toString() %> </placeholder> <br/>
						<bold>Tipo account:</bold> <placeholder id="tipo"><%= utente_.getTipoUtente().toString() %> </placeholder> <br/>
					</p>
				</div>
				
				<%
				AbbonamentoBean abb = (AbbonamentoBean) request.getAttribute("abbonamento");
				if (abb != null) {
					List<CorsoBean> corsiScelti = (List<CorsoBean>)(new IncludeDAO()).doRetrieveAllByAbbonamentoId(abb.getIdAbbonamento());
					String corsiSceltiFormattato = corsiScelti.get(0).getNomeCorso();
					corsiScelti.remove(0);
					for (CorsoBean c : corsiScelti) corsiSceltiFormattato += ", " + c.getNomeCorso();
				%>
				<div>
					<p class="titolo piccolo">ABBONAMENTO ATTIVO</p>
					<p class="paragrafo grande">
						<bold>Validita:</bold> <placeholder id="dataAcquisto"> <%= abb.getDataAcquisto().toString() %> - <%= abb.getDataAcquisto().plusMonths(abb.getDurata()) %> </placeholder>  <br/>
						<bold>Max accessi settimanali:</bold> <placeholder id="maxAccessiSettimanali"> <%= abb.getMaxAccessiSettimanali() %> </placeholder>  <br/>
						<bold>Corsi scelti:</bold> <placeholder id="corsiScelti"> <%= corsiSceltiFormattato %>  </placeholder> <br/>
						<bold>Costo:</bold> <placeholder id="costo"> $<%= abb.getCosto() %>  </placeholder> <br/>
					</p>
				</div>
				<% } else { %>
				<div>
					<p class="titolo piccolo">ABBONAMENTO ATTIVO</p>
					<p class="paragrafo grande">
						<bold>Validita:</bold> <placeholder id="dataAcquisto"> - </placeholder>  <br/>
						<bold>Max accessi settimanali:</bold> <placeholder id="maxAccessiSettimanali"> - </placeholder>  <br/>
						<placeholder id="corsiScelti"> <bold>Corsi scelti:</bold>  -   <br/> </placeholder>
						<bold>Costo:</bold> <placeholder id="costo"> -  </placeholder> <br/>
					</p>
				</div>
				<% } %>
			</div>
			
			<div class="lezioni-prenotate">
				<p class="titolo piccolo">LEZIONI PRENOTATE</p>
				<div class="card-grid" id="lezioni">
					<% 
				    List<LezioneBean> lezioni = (List<LezioneBean>)request.getAttribute("lezioniPrenotate");
				    if(lezioni != null && !lezioni.isEmpty()) {
			        for(LezioneBean lezione : lezioni) {
				    %>
					<div class="card prenotazione">
						<p class="titolo piccolo" style="min-width: 65%;"> <%= lezione.getDataOra().getDayOfMonth() +" "+ lezione.getDataOra().getMonth().toString() %></p>
						<p><bold>Orario:</bold> <%= lezione.getDataOra().toLocalTime().toString() %> - <%= lezione.getDataOra().plusMinutes(lezione.getDurata()).toLocalTime().toString() %> </p>
						<p><bold>Iscritti:</bold> <%= lezione.getNumIscritti() %> </p>
						<p><bold>Corso:</bold> <%= lezione.getNomeCorso() %> </p>
					</div>
					<%
			        }}
				    %>
				</div>
			</div>
		</div>
		
	</body>
</html>