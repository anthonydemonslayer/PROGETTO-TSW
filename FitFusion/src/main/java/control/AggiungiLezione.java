package control;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
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
import model.utente.UtenteDAO;


@WebServlet("/AggiungiLezione")
public class AggiungiLezione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiLezione() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtenteBean utente = (UtenteBean) request.getSession().getAttribute("utente");
		
		if (utente != null && utente.getTipoUtente() == TipoUtente.Amministratore) {
			LocalDateTime dataOra = LocalDateTime.parse(request.getParameter("dataOra"));
			System.out.println(dataOra.toString());
			String nomeCorso = (String) request.getParameter("corso");
			Integer idIstruttore = Integer.parseInt(request.getParameter("istruttore").split(":")[0]);
			LezioneBean lezione = new LezioneBean();
			LezioneDAO lezioneDAO = new LezioneDAO();

			System.out.println("Nome corso: " + nomeCorso);
			
			lezione.setNomeCorso(nomeCorso);
			lezione.setIdUtente(idIstruttore);
			lezione.setCosto(Float.parseFloat(request.getParameter("costo")));
			lezione.setDurata(Integer.parseInt(request.getParameter("durata")));
			lezione.setDataOra(dataOra);

			try {
				lezioneDAO.doSave(lezione);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			request.getRequestDispatcher("adminGestisciLezioni.jsp").forward(request, response);
		} else
			response.sendRedirect("accesso.jsp");
	}

}
