package control;

import java.io.IOException;
import java.sql.SQLException;
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

/**
 * Servlet implementation class AggiungiAlCarrelloServlet
 */
@WebServlet("/AggiungiAlCarrello")
public class AggiungiAlCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AggiungiAlCarrello() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AbbonamentoBean abb = (AbbonamentoBean) request.getAttribute("abbonamento");
		String[] lezioniId = request.getParameterValues("lezioni");
		LezioneDAO lezioneDAO = new LezioneDAO();
		CarrelloModel carrello = (CarrelloModel) request.getSession().getAttribute("carrello");
		if (carrello == null) carrello = new CarrelloModel();
		UtenteBean utente = (UtenteBean) request.getSession().getAttribute("utente");
		
		if (utente != null) {
			if (abb != null) {
				carrello.setAbbonamento(abb);
				carrello.setCorsi((ArrayList<IncludeBean>) request.getAttribute("corsiAbbonamento"));
			}	
			
			if (lezioniId != null) {
				for (String s : lezioniId) {
					try {
						Integer lezioneID = Integer.decode(s);
						Integer utenteID = utente.getIdUtente();
						PrenotaBean p = new PrenotaBean();
						p.setIdLezione(lezioneID);  p.setIdUtente(utenteID);
		
						carrello.addPrenotazione(p);
					} catch (NumberFormatException e) {
						e.printStackTrace();
					}
				}
			}
			
			request.getSession().setAttribute("carrello", carrello);
			request.getSession().setAttribute("abbonamento", null);
			response.sendRedirect("carrello.jsp");
		} 
		else response.sendRedirect("accesso.jsp");
	}

}
