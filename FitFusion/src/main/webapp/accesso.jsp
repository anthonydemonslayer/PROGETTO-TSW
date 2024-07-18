<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Accedi</title>
		<%= response.getHeader("Global-CSS") %>
		<link rel='stylesheet' type='text/css' href='css/accesso-style.css'>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	</head>
	
	<body>
		<%@ include file="navbar.jsp" %>
		
		<spacer></spacer>
		
		<%
		String tipoAccesso = (String) request.getParameter("tipo");
		if (tipoAccesso != null && tipoAccesso.equals("signup")) { 
		%>
		<form action="${pageContext.request.contextPath}/Registrazione" method="post">
			<p class="titolo grande">REGISTRATI</p>
		
			<div class="textbox">
				<p>Nome</p>
				<input type="text" name="nome" required autofocus></input>
			</div>
			<div class="textbox">
				<p>Cognome</p>
				<input type="text" name="cognome" required autofocus></input>
			</div>
			<div class="textbox">
				<p>Email</p>
				<input type="email" name="indirizzo" required autofocus></input>
			</div>
			<div class="textbox">
				<p>Telefono</p>
				<input type="tel" name="telefono" required autofocus></input>
			</div>
			<div class="textbox">
				<p>Password</p>
				<input type="password" name="password" required autofocus></input>
			</div>
			
			<a href="accesso.jsp?tipo=login">Sei gi&agrave; registrato? Accedi</a>
			<button type="submit" class="cta">REGISTRATI</button>
		</form>
		<% } else { %>
		<form action="${pageContext.request.contextPath}/Login" method="post">
			<p class="titolo grande">ACCEDI</p>
		
			<div class="textbox">
				<p>Email</p>
				<input type="email" name="indirizzo" required autofocus></input>
			</div>
			<div class="textbox">
				<p>Password</p>
				<input type="password" name="password" required autofocus></input>
			</div>
			
			<% if (request.getAttribute("credenzialiErrate") != null) { %>
			<p style="color: var(--rosso);">Credenziali errate!</p>
			<% } %>
			
			<a href="accesso.jsp?tipo=signup">Non sei ancora registrato? Registrati</a>
			<button type="submit" class="cta">ACCEDI</button>
		</form>
		<% } %>
		
	</body>
</html>