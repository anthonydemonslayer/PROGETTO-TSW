package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.corso.CorsoBean;
import model.corso.CorsoDAO;
import model.utente.UtenteBean;


@WebFilter(urlPatterns = {"/adminGestisciCorsi.jsp", "/adminGestisciLezioni.jsp"}, dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class GestioneCorsiFilter extends HttpFilter implements Filter {
       
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			List<CorsoBean> corsi = (List<CorsoBean>) (new CorsoDAO()).doRetriveAll("");
			request.setAttribute("corsi", corsi);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		chain.doFilter(request, response);
	}


}
