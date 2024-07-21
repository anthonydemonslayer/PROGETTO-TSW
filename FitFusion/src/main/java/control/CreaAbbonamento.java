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


@WebServlet("/CreaAbbonamento")
public class CreaAbbonamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreaAbbonamento() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("corsi", request.getParameterValues("corsi"));
		request.getRequestDispatcher("completaAbbonamento.jsp").forward(request, response);
	}

}
