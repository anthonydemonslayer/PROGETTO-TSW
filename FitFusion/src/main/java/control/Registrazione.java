package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.utente.*;


@WebServlet("/Registrazione")

public class Registrazione extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String password = request.getParameter("password");
		String email = request.getParameter("indirizzo");
		String telefono = request.getParameter("telefono");
		
		UtenteDAO utenteDAO = new UtenteDAO();
		
		try {
			if(utenteDAO.doRetreiveByEmail(email) != null) {
				response.sendRedirect("accesso.jsp");
			} else {
				UtenteBean utente = new UtenteBean();
				utente.setNomeUtente(nome);
				utente.setCognome(cognome);
				utente.setPassword(password);
				utente.setTelefono(telefono);
				utente.setTipoUtente(TipoUtente.Utente);
				utente.setIndirizzo(email);

				utenteDAO.doSave(utente);
				request.getSession().setAttribute("utente", utente);
				response.sendRedirect("home.jsp");
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
