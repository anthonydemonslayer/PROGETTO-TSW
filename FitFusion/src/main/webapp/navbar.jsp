<%@ page import="utils.UserUtils" %>

<nav class="navbar">
    <div class="titolo-piccolo">FIT FUSION</div>
    
    <%!
	private String getFontWeightCSS(HttpServletRequest request, String pageName) {
    	if (UserUtils.getVisitedJSP(request).equals(pageName))
    		return "class='font-grassetto'";
    	else
    		return "";
    }
	%>
	
    <div class="navbar-menu">
        <a href="home.jsp" <%= getFontWeightCSS(request, "home.jsp") %>>HOME</a>
        <a href="#" <%= getFontWeightCSS(request, "login.jsp") %>>LOGIN / SIGNUP</a>
    </div>
    
    <div class="navbar-buttons">
        <button style = "background-image: url( 'images/carrello.svg' );"></button>
        <button style = "background-image: url( 'images/account.svg' );"></button>
        <% if (UserUtils.isUserOfType(session, "admin")) {%>
    		<button style = "background-image: url( 'images/strumentiAdmin.svg' );"></button>
		<% } %>
    </div>
</nav>