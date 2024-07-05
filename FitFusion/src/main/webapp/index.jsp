<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Home</title>
		<%= response.getHeader("Global-CSS") %>
	</head>
	<body>	
		<nav class="navbar">
        <div class="titolo-piccolo">FIT FUSION</div>
        <div class="navbar-menu">
            <a href="#">HOME</a>
            <a href="#">CONTATTACI</a>
            <a href="#">LOGIN / SIGNUP</a>
        </div>
        <div class="navbar-buttons">
            <button style = "background-image: url( 'images/carrello.svg' );" class="icon"></button>
            <button style = "background-image: url( 'images/account.svg' );" class="icon"></button>
        </div>
    </nav>
    
	</body>
</html>