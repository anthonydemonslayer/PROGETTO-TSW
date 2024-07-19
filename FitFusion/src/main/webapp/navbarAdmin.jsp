<%@ page import="utils.UserUtils" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<link rel='stylesheet' type='text/css' href='css/navbarAdmin-style.css'>

<%= response.getHeader("Global-CSS") %>

 <%!
	private String getButtonClass(HttpServletRequest request, String pageName) {
    	if (UserUtils.getVisitedJSP(request).equals(pageName))
    		return "class='secondario'";
    	else
    		return "class='primario'";
    }
%>

<div class="navbarAdmin">
	<p class="titolo grande">DASHBOARD ADMIN</p>
	<div class="bottoni">
		<button <%= getButtonClass(request, "gestisciUtenti.jsp") %> onclick="location.href='adminGestisciUtenti.jsp';">GESTISCI UTENTI</button>
		<button <%= getButtonClass(request, "gestisciCorsi.jsp") %> onclick="location.href='adminGestisciCorsi.jsp';">GESTISCI CORSI</button>
		<button <%= getButtonClass(request, "gestisciLezioni.jsp") %> onclick="location.href='adminGestisciLezioni.jsp';">GESTISCI LEZIONI</button>
		<button <%= getButtonClass(request, "storicoOrdini.jsp") %> onclick="location.href='adminStoricoOrdini.jsp';">STORICO ORDINI</button>
	</div>
</div>

