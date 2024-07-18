package model.corso;

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



@WebFilter("/dettagliCorso.jsp")
public class DettagliCorsoFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;
       
	private CorsoDAO corsoDAO;

    public void init(FilterConfig filterConfig) throws ServletException {
        corsoDAO = new CorsoDAO(); // Inizializza il DAO
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException{
    	try {
    		String corso = (String) request.getParameter("corso");

    		if (corso != null) {
		        request.setAttribute("corso", corsoDAO.doRetreiveByKey(corso)); // Passa la lista alla JSP
    		}
	        chain.doFilter(request, response); // Continua la catena di filtri
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
