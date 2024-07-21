<%@page import="model.corso.CorsoBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>Gestisci Corsi</title>
		<link rel='stylesheet' type='text/css' href='css/gestisciCorsi-style.css'>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	</head>

	<body>	
		<%@ include file="navbar.jsp" %>

		<spacer></spacer>

		<div class="pagina-gestisci-corsi">
			<%@ include file="navbarAdmin.jsp" %>
			
			<div class="forms">
				<form action="ModificaCorso" method="post">
					<p class="titolo grande">MODIFICA CORSO</p>
				
					<div class="custom-select">
						<select id="corso" name="corso">
							<%
							List<CorsoBean> corsi = (List<CorsoBean>) request.getAttribute("corsi");
							if (corsi != null && !corsi.isEmpty())
							for (CorsoBean c : corsi) {
							%>
							<option><%= c.getNomeCorso() %></option>
							<% } %>
						</select>
					</div>
					
					<div class="textbox">
						<p>Nome</p>
						<input type="text" id="textNome" name="nuovoNomeCorso" required></input>
					</div>
					<div class="textbox">
						<p>Descrizione</p>
						<textarea cols="50" rows="10" id="descrizione" name="descrizione" required></textarea>
					</div>
					
					<button type="submit" class="primario">APPLICA MODIFICHE</button>
				</form>
				
				<form action="AggiungiCorso" method="post">
					<p class="titolo grande">AGGIUNGI CORSO</p>
				
					<div class="textbox">
						<p>Nome</p>
						<input type="text" id="corso" name="corso" required></input>
					</div>
					<div class="textbox">
						<p>Descrizione</p>
						<textarea cols="50" rows="10" id="descrizione" name="descrizione" required></textarea>
					</div>
					
					<button type="submit" class="primario">AGGIUNGI CORSO</button>
				</form>
			</div>
		</div>
	</body>
</html>