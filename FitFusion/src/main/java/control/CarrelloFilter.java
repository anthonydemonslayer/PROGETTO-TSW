package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CarrelloModel;
import model.abbonamento.*;
import model.corso.CorsoDAO;
import model.lezione.LezioneBean;
import model.prenota.PrenotaDAO;
import model.utente.UtenteBean;



@WebFilter("/carrello.jsp")
public class CarrelloFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;
       

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException{
    	CarrelloModel carrello = (CarrelloModel) request.getSession().getAttribute("carrello");
		if (carrello != null) {
			
		}
		chain.doFilter(request, response); // Continua la catena di filtri 
	}
}
