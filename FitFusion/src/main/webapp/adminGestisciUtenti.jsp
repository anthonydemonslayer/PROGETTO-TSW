<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>Gestisci Utenti</title>
		<link rel='stylesheet' type='text/css' href='css/gestisciUtenti-style.css'>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	</head>

	<body>	
		<%@ include file="navbar.jsp" %>

		<spacer></spacer>

		<div class="pagina-gestisci-utenti">
			<%@ include file="navbarAdmin.jsp" %>
		
			<div class="utente">
				<div class="custom-select">
					<select>
						<option>Giovanni Brancaccio</option>
						<option>Mario Rossi</option>
						<option>...</option>
					</select>
				</div>
				<div class="custom-select">
					<select>
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