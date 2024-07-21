package control;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CarrelloModel;
import model.abbonamento.AbbonamentoBean;
import model.include.IncludeBean;
import model.lezione.LezioneBean;
import model.lezione.LezioneDAO;
import model.prenota.PrenotaBean;
import model.utente.UtenteBean;


@WebServlet("/CompletaAbbonamento")
public class CompletaAbbonamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompletaAbbonamento() {
        super();
    }

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
		UtenteBean utente = (UtenteBean) request.getSession().getAttribute("utente");
		
		if (utente != null) {
			String[] corsi = (String[]) request.getSession().getAttribute("corsi");
			int costo = Integer.decode(request.getParameter("costo"));
			LocalDate dataAcquisto = LocalDate.now();
			int durata = Integer.decode(request.getParameter("durata"));
			int maxAccessiSettimanali = Integer.decode(request.getParameter("maxAccessiSettimanali"));
			int idUtente = utente.getIdUtente();
			
			AbbonamentoBean abb = new AbbonamentoBean();
			abb.setCosto(costo);
			abb.setDataAcquisto(dataAcquisto);
			abb.setDurata(durata);
			abb.setIdUtente(idUtente);
			abb.setMaxAccessiSettimanali(maxAccessiSettimanali);
	
			request.setAttribute("abbonamento", abb);
			
			List<IncludeBean> corsiInclusi = new ArrayList<IncludeBean>();
			for (String nomeCorso : corsi) {
				IncludeBean include = new IncludeBean();
				include.setIdAbbonamento(-1);
				include.setNomeCorso(nomeCorso);
				corsiInclusi.add(include);
			}
			
			request.setAttribute("corsiAbbonamento", corsiInclusi);
			request.getRequestDispatcher("AggiungiAlCarrello").forward(request, response);
		} 
		else response.sendRedirect("accesso.jsp");
	}

}
