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
import model.lezione.LezioneBean;
import model.lezione.LezioneDAO;
import model.prenota.PrenotaBean;
import model.utente.UtenteBean;


@WebServlet("/ProcessaCarrello")
public class ProcessaCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ProcessaCarrello() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CarrelloModel carrello = (CarrelloModel) request.getSession().getAttribute("carrello");
		UtenteBean utente = (UtenteBean) request.getSession().getAttribute("utente");

		if (utente == null) {
			response.sendRedirect("accesso.jsp");
		}
		if (carrello == null) carrello = new CarrelloModel();

		carrello.acquista(utente);
		request.getSession().setAttribute("carrello", null);
		
		response.sendRedirect("carrello.jsp");
	}

}
