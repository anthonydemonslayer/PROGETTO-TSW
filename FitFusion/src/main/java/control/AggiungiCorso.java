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
import model.corso.CorsoBean;
import model.corso.CorsoDAO;
import model.lezione.LezioneBean;
import model.lezione.LezioneDAO;
import model.prenota.PrenotaBean;
import model.utente.TipoUtente;
import model.utente.UtenteBean;


@WebServlet("/AggiungiCorso")
public class AggiungiCorso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiCorso() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtenteBean utente = (UtenteBean) request.getSession().getAttribute("utente");
		
		if (utente != null && utente.getTipoUtente() == TipoUtente.Amministratore) {
			String nomeCorso = (String) request.getParameter("corso");
			String descrizione = (String) request.getParameter("descrizione");
			CorsoDAO corsoDAO = new CorsoDAO();
			CorsoBean corso = new CorsoBean();
			corso.setNomeCorso(nomeCorso);
			corso.setDescrizione(descrizione);
			
			try {
				corsoDAO.doSave(corso);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			request.getRequestDispatcher("adminGestisciCorsi.jsp").forward(request, response);
		} else
			response.sendRedirect("accesso.jsp");
	}

}
