<%@ page import="utils.UserUtils" %>
<%@ page import="model.utente.*" %>

<% UtenteBean utente = (UtenteBean) request.getSession().getAttribute("utente"); %>

<link rel="stylesheet" type="text/css" href="/FitFusion/css/navbar-style.css">
<script src="js/corsi.js" defer></script>

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
        <% if (utente == null) { %>
        <a href="accesso.jsp" <%= getFontWeightCSS(request, "accesso.jsp") %>>ACCEDI / REGISTRATI</a>
        <% } else { %>
                <a href="Logout">LOGOUT</a>
        <% } %>
    </div>
    
    <div class="navbar-buttons">
        <button style = "background-image: url( 'images/carrello.svg' );" onclick="location.href='carrello.jsp';"></button>
        <button style = "background-image: url( 'images/account.svg' );" onclick="location.href='dashboardUtente.jsp';" ></button>
        <% if (utente != null && utente.getTipoUtente() == TipoUtente.Amministratore) { %>
    		<button style = "background-image: url( 'images/strumentiAdmin.png' );" onclick="location.href='adminGestisciUtenti.jsp';"></button>
		<% } %>
    </div>
</nav>