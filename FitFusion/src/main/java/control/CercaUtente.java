package control;

import java.io.IOException;
import java.io.PrintWriter;
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
import model.utente.UtenteDAO;


@WebServlet("/CercaUtente")
public class CercaUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cognome = request.getParameter("cognome");
		UtenteDAO utenteDAO = new UtenteDAO();
		try {
			List<UtenteBean> utenti = utenteDAO.doRetreiveAllByCognome(cognome);
			
			response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        PrintWriter out = response.getWriter();
	        out.print(convertToJson(utenti));
	        out.flush();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String convertToJson(List<UtenteBean> utenti) {
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < utenti.size(); i++) {
            UtenteBean utente = utenti.get(i);
            json.append("{")
                .append("\"nome\":\"").append(utente.getNomeUtente()).append("\",")
                .append("\"cognome\":\"").append(utente.getCognome()).append("\",")
                .append("\"tipo\":\"").append(utente.getTipoUtente()).append("\",")
                .append("\"id\":\"").append(utente.getIdUtente()).append("\"")
                .append("}");
            if (i < utenti.size() - 1) {
                json.append(",");
            }
        }
        json.append("]");
        return json.toString();
    }

}
