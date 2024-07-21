package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
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
import model.prenota.PrenotaDAO;
import model.utente.UtenteBean;
import model.utente.UtenteDAO;


@WebServlet("/OttieniDettagliUtente")
public class OttieniDettagliUtente extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public OttieniDettagliUtente() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUtente = Integer.parseInt(request.getParameter("idUtente"));
        UtenteDAO utenteDAO = new UtenteDAO();
        PrenotaDAO prenotaDAO = new PrenotaDAO();
        UtenteBean utente = new UtenteBean();
        AbbonamentoBean abbonamento = new AbbonamentoBean();
        AbbonamentoDAO abbonamentoDAO = new AbbonamentoDAO();

		try {
			utente = utenteDAO.doRetreiveByKey(idUtente);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			abbonamento = abbonamentoDAO.doRetreiveByKey(idUtente);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(utente.toString());
        List<LezioneBean> lezioni = new ArrayList<>();
		try {
			lezioni = (List<LezioneBean>) prenotaDAO.doRetrieveAllByUserId(idUtente);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String abbonamentoJSON = "";
        if (abbonamento != null) abbonamentoJSON = ", \"abbonamento\":" + convertAbbonamentoToJson(abbonamento);
        
        out.print("{\"utente\":" + convertUtenteToJson(utente) + abbonamentoJSON + ", \"lezioni\":" + convertLezioniToJson(lezioni) + "}");
        out.flush();
    }


    private List<LezioneBean> ottieniLezioniUtente(int idUtente) {
        return null;
    }

    private String convertUtenteToJson(UtenteBean utente) {
    	StringBuilder json = new StringBuilder("");
    	json.append("{")
        .append("\"id\":\"").append(utente.getIdUtente()).append("\",")
        .append("\"nomeUtente\":\"").append(utente.getNomeUtente()).append("\",")
        .append("\"cognome\":\"").append(utente.getCognome()).append("\",")
        .append("\"indirizzo\":\"").append(utente.getIndirizzo()).append("\",")
        .append("\"tipo\":\"").append(utente.getTipoUtente()).append("\",")
        .append("\"telefono\":\"").append(utente.getTelefono()).append("\"")
        .append("}");
        return json.toString();
    }
    
    private String convertAbbonamentoToJson(AbbonamentoBean abbonamento) {    	
    	StringBuilder json = new StringBuilder("");
    	json.append("{")
        .append("\"costo\":\"").append(abbonamento.getCosto()).append("\",")
        .append("\"dataAcquisto\":\"").append(abbonamento.getDataAcquisto().format(DateTimeFormatter.ISO_LOCAL_DATE)).append("\",")
        .append("\"durata\":\"").append(abbonamento.getDurata()).append("\",")
        .append("\"maxAccessiSettimanali\":\"").append(abbonamento.getMaxAccessiSettimanali()).append("\"")
        .append("}");
        return json.toString();
    }

    private String convertLezioniToJson(List<LezioneBean> lezioni) {
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < lezioni.size(); i++) {
            LezioneBean lezione = lezioni.get(i);
            json.append("{")
                .append("\"idLezione\":\"").append(lezione.getIdLezione()).append("\",")
                .append("\"costo\":\"").append(lezione.getCosto()).append("\",")
                .append("\"dataOra\":\"").append(lezione.getDataOra().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME).replace("T", " ")).append("\",")
                .append("\"nomeCorso\":\"").append(lezione.getNomeCorso()).append("\"")
                .append("}");
            if (i < lezioni.size() - 1) {
                json.append(",");
            }
        }
        json.append("]");
        return json.toString();
    }
}
