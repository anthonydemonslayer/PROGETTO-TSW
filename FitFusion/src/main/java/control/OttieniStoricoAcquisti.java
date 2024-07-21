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
import model.abbonamento.AbbonamentoDAO;
import model.lezione.LezioneBean;
import model.lezione.LezioneDAO;
import model.prenota.PrenotaBean;
import model.utente.TipoUtente;
import model.utente.UtenteBean;


@WebServlet("/OttieniStoricoAcquisti")
public class OttieniStoricoAcquisti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtenteBean utente = (UtenteBean) request.getSession().getAttribute("utente");
		
		if (utente != null && utente.getTipoUtente() == TipoUtente.Amministratore) {
			List<AbbonamentoBean> abbonamenti = new ArrayList<AbbonamentoBean>();
			List<LezioneBean> lezioni = new ArrayList<LezioneBean>();
			LocalDate da = LocalDate.parse(request.getParameter("da"));
			LocalDate a = LocalDate.parse(request.getParameter("a"));

			try {
				abbonamenti = (List<AbbonamentoBean>) (new AbbonamentoDAO()).doRetrieveAllByPeriodo(da, a);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				lezioni = (List<LezioneBean>) (new LezioneDAO()).doRetrieveAllByPeriodo(da, a);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("lezioni", lezioni);
			request.setAttribute("abbonamenti", abbonamenti);
			request.getRequestDispatcher("adminStoricoOrdini.jsp").forward(request, response);
		} else response.sendRedirect("accesso.jsp");
	}

}
