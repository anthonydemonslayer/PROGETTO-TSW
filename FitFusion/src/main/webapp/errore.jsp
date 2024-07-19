<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.StringWriter" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page isErrorPage = "true" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>ERRORE</title>
		<link rel='stylesheet' type='text/css' href='css/home-style.css'>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	</head>

	<body>		
		<a href="home.jsp" style="position: absolute; top: 20%; left: 20%; "> ERRORE, TORNA ALLA HOME </p>
		<% if (exception != null) {StringWriter sw = new StringWriter(); exception.printStackTrace(new PrintWriter(sw)); } %>
	</body>
</html>