<%@ page import="utils.UserUtils" %>

<link rel="stylesheet" type="text/css" href="/FitFusion/css/navbar-style.css">

<nav class="navbar">
    <a href="home.jsp" class="titolo piccolo">FIT FUSION</a>
    
    <%!
	private String getFontWeightCSS(HttpServletRequest request, String pageName) {
    	if (UserUtils.getVisitedJSP(request).equals(pageName))
    		return "class='font grassetto'";
    	else
    		return "";
    }
	%>
	
    <div class="navbar-menu">
        <a href="home.jsp" <%= getFontWeightCSS(request, "home.jsp") %>>HOME</a>
        <a href="accesso.jsp" <%= getFontWeightCSS(request, "accesso.jsp") %>>ACCEDI / REGISTRATI</a>
    </div>
    
    <div class="navbar-buttons">
        <button style = "background-image: url( 'images/carrello.svg' );" onclick="location.href='carrello.jsp';"></button>
        <button style = "background-image: url( 'images/account.svg' );" onclick="location.href='dashboardUtente.jsp';" ></button>
        <% if (UserUtils.isUserOfType(session, "guest")) {%>
    		<button style = "background-image: url( 'images/strumentiAdmin.png' );" onclick="location.href='gestisciUtenti.jsp';"></button>
		<% } %>
    </div>
</nav>