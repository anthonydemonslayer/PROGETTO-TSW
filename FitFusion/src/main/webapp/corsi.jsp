<%@ page import="java.util.List" %>
<%@ page import="model.corso.*" %>


<link rel='stylesheet' type='text/css' href='css/corsi-style.css'>

<spacer></spacer>

<form action="CreaAbbonamento" method="POST" class="corsi">
	<span style="justify-content: flex-start; gap: 20px;">
		<p class="titolo grande">Corsi</p>
		<button type="submit" id="creaAbbonamento" disabled class="cta">CREA ABBONAMENTO</button>
	</span>
	
	<p class="paragrafo grande">Spunta i corsi che vuoi includere nell&rsquo;abbonamento, o clicca su &ldquo;Dettagli&rdquo; per prenotare le singole lezioni.</p>
	
	<div class="card-grid">
	
		<% 
	    List<CorsoBean> corsi = (List<CorsoBean>)request.getAttribute("corsi");
	    if(corsi != null && !corsi.isEmpty()) {
        for(CorsoBean corso : corsi) {
        	String nome = corso.getNomeCorso();
	    %>
		<div class="card corso">
			<img alt="" src="images/<%= nome %>.jpg">
			<p class="titolo piccolo"><%= nome %></p>
			<p class="descrizione"><%= corso.getDescrizione() %></p>
			<span>
				<button type="button" class="primario" style="min-width: 75%;" onclick="location.href='dettagliCorso.jsp?corso=<%= nome %>';"> Dettagli </button>
				<div class="checkbox-wrapper">
					<label> <input type="checkbox" class="check" name="corsi" value="<%= nome %>"/> <span class="checkbox"></span> </label>
				</div>
			</span>
		</div>
	    <%
        }}
	    %>
	</div>
</form>