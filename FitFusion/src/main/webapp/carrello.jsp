<%@page import="model.lezione.LezioneBean"%>
<%@page import="model.prenota.PrenotaBean"%>
<%@page import="model.corso.CorsoBean"%>
<%@page import="model.include.IncludeDAO"%>
<%@page import="model.abbonamento.AbbonamentoBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%@ page import="java.util.List" %>

<%
CarrelloModel carrello = (CarrelloModel) request.getSession().getAttribute("carrello");
if (carrello == null) carrello = new CarrelloModel();
List<LezioneBean> lezioni = carrello.getLezioni();
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>Carrello</title>
		<%= response.getHeader("Global-CSS") %>
		<link rel='stylesheet' type='text/css' href='css/carrello-style.css'>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	</head>

	<body>	
		<%@ include file="navbar.jsp" %>
		
		<spacer></spacer>

		<p class="titolo grande" style="min-width: 100%; text-align: center; padding-top: 5vh;">Carrello</p>
		
		<div class="pagina-carrello">
			<div class="elenco-prodotti">
				<%
				AbbonamentoBean abb = carrello.getAbbonamento();
				if (abb != null) {
				List<CorsoBean> corsiScelti = carrello.getCorsi();
				String corsiSceltiFormattato = corsiScelti.get(0).getNomeCorso();
				corsiScelti.remove(0);
				for (CorsoBean c : corsiScelti) corsiSceltiFormattato += ", " + c.getNomeCorso();
				%>
				<div class="prodotto">
					<div class="info">
						<p class="paragrafo grande">ABBONAMENTO</p>
						<p>
							<bold>Durata in mesi:</bold> <%= abb.getDurata() %> <br/>
							<bold>Max accessi settimanali:</bold> <%= abb.getMaxAccessiSettimanali() %> <br/>
							<bold>Corsi scelti:</bold> <%= corsiSceltiFormattato %> <br/>
						</p>
					</div>
					
					<p class="paragrafo grande">$<%= abb.getCosto() %></p>
					
					<form method="POST" action="CancellaAbbonamento">
						<button class="contieni-immagine vuoto">
							<img alt="" src="images/cancellaProdotto.png">
						</button>
					</form>
				</div>
				
				<% if (lezioni.size() > 0) { %>
				<separator></separator>				
				<% }} %>
				
				
				<% 
			    if (lezioni != null && !lezioni.isEmpty()) {
			    int i = 0;
		        for(LezioneBean lezione : lezioni) {
		        i++;
			    %>
				<div class="prodotto">
					<div class="info">
						<p class="paragrafo grande" style="text-transform: uppercase;">LEZIONE <%= lezione.getNomeCorso() %>, <%= lezione.getDataOra().toLocalDate() %></p>
						<p><bold>Orario:</bold> <%= lezione.getDataOra().toLocalTime() %> - <%= lezione.getDataOra().toLocalTime().plusMinutes(lezione.getDurata()) %></p>
					</div>
					
					<p class="paragrafo grande">$<%= lezione.getCosto() %></p>
					
					<form action="CancellaPrenotazione" method="POST">
						<input type="hidden" name="lezioneID" value="<%= lezione.getIdLezione() %>"/>
						<button type="submit" class="contieni-immagine vuoto">
							<img alt="" src="images/cancellaProdotto.png">
						</button>
					</form>
				</div>
				
				<% if (i < lezioni.size()) { %>
				<separator></separator>
				<% }}} %>
			</div>
			
			<div class="totale">
				<div>
				<p class="titolo piccolo">PREZZO: <%= carrello.getPrezzo() %></p>
				</div>
				<span style="gap: 10px;">
					<form action="/ProcessaCarrello" method="POST">
					<button class="cta" id="acquistaBtn">ACQUISTA</button>
					</form>
					<button class="contieni-immagine" onclick="location.href='SvuotaCarrello';">
						<img alt="" src="images/cancellaCarrello.svg">					
					</button>
				</span>
			</div>
		</div>
		
	</body>
</html>