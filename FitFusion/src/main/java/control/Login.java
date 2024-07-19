package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.utente.*;


@WebServlet("/Login")

public class Login extends HttpServlet {
	public static final int ADMIN = 0;
	public static final int REGISTRATO = 1;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("indirizzo");
		String password = request.getParameter("password");
		
		try {
				String redirectedPage;
				int tipoUtente = checkUser(email, password);
				UtenteDAO utenteDAO = new UtenteDAO();
				UtenteBean utenteBean = utenteDAO.doRetreiveByKey(email);
				request.getSession().setAttribute("utente", utenteBean);
								
				switch (tipoUtente) {
					case ADMIN:
						request.getSession().setAttribute("tipoUtente", ADMIN);
						redirectedPage = "home.jsp";
						break;
					case REGISTRATO:
						request.getSession().setAttribute("tipoUtente", REGISTRATO);
						redirectedPage = "home.jsp";
						break;
					default:
						request.setAttribute("credenzialiErrate", true);
						request.getRequestDispatcher("accesso.jsp").forward(request, response);
						return;
				}
				response.sendRedirect(redirectedPage);
				
			} catch (SQLException e) {
				System.out.println("EXCEPTION");
				throw new RuntimeException(e);
			}
		}
		
		private int checkUser(String email, String password) throws SQLException {
			UtenteDAO utenteDAO = new UtenteDAO();
			UtenteBean utenteBean = utenteDAO.doRetreiveByKey(email);
			
			if(utenteBean == null || !(utenteBean.getPassword().equals(password)))
				return -1;
			else {
				if(utenteBean.getTipoUtente().equals("amministratore"))
					return ADMIN;
				else
					return REGISTRATO;
			}
		}
	}

