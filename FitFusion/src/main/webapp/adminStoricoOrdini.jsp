<%@page import="model.lezione.LezioneBean"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="model.abbonamento.AbbonamentoBean"%>
<%@page import="model.abbonamento.AbbonamentoDAO"%>
<%@page import="java.util.List"%>
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
			
			<form action="OttieniStoricoAcquisti" method="POST">
				<span style="flex-wrap: wrap; align-items: flex-end;">
					<div class="textbox">
						<p><bold>Da</bold></p>
						<div class="date-wrapper">
							<input type="date" name="da" required></input>
						</div>
					</div>
					
					<div class="textbox">
						<p><bold>A</bold></p>
						<div class="date-wrapper">
							<input type="date" name="a" required></input>
						</div>
					</div>
					
					<button type="submit" id="cerca" class="primario">CERCA</button>
				</span>
			</form>
			
			<div class="card-grid">			
				<%
				List<AbbonamentoBean> abbonamenti = (List<AbbonamentoBean>) request.getAttribute("abbonamenti");
				if (abbonamenti != null && !abbonamenti.isEmpty())
				for (AbbonamentoBean a : abbonamenti) {
				UtenteBean u = (new UtenteDAO()).doRetreiveByKey(a.getIdUtente());
				%>
				<div class="card prenotazione">
					<p class="titolo piccolo" style="min-width: 65%;">ABBON.</p>
					<p><bold>Creato da:</bold> <%= u.getNomeUtente() + " " + u.getCognome() %></p>
					<p><bold>Importo:</bold> $<%= a.getCosto() %></p>
					<p><bold>Data:</bold> <%= a.getDataAcquisto().format(DateTimeFormatter.ISO_DATE) %></p>
				</div>
				<% } %>

				<%
				List<LezioneBean> lezioni = (List<LezioneBean>) request.getAttribute("lezioni");
				if (lezioni != null && !lezioni.isEmpty())
				for (LezioneBean l : lezioni) {
				%>
				<div class="card prenotazione">
					<p class="titolo piccolo" style="min-width: 65%; text-transform: uppercase;">LEZ. <%= l.getNomeCorso() %></p>
					<p><bold>Importo:</bold> $<%= l.getCosto() %></p>
					<p><bold>Data:</bold> <%= l.getDataOra().format(DateTimeFormatter.ISO_DATE) %></p>
				</div>
				<% } %>
				
			</div>
		</div>
	</body>
</html>