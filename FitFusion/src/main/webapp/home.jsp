<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>Home</title>
		<%= response.getHeader("Global-CSS") %>
		<link rel='stylesheet' type='text/css' href='css/home-style.css'>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	</head>

	<body>	
		<%@ include file="navbar.jsp" %>
		
		<div class="pagina-landing">
			<div class="lato-sinistro">
				<p class="titolo grande">ALLENATI, DIVERTITI, TRANSFORMATI</p>
				<p class="paragrafo grande">Scopri un nuovo modo di vivere il fitness.</p>
				
				<span class="info">
					<img alt="" src="images/via.svg"/>
					<p>Via De Cesari 22</p>
				</span>
				<span class="info">
					<img alt="" src="images/telefono.svg"/>
					<p>331 221 4353</p> 
				</span>
				
				<button class="cta" onClick="document.getElementById('corsi').scrollIntoView();" >VAI AI CORSI</button>
			</div>
			
			<img alt="" src="images/palestrato.png"/>
		</div>
		
		<section id="corsi"/>
		<%@ include file="corsi.jsp" %>
		
	</body>
</html>