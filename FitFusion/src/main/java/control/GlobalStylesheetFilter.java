package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.utente.UtenteDAO;
import model.corso.*;

@WebFilter(description = "Applica lo stile css di base a tutte le pagine del sito web", urlPatterns = { "*.jsp" }, dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class GlobalStylesheetFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	@Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException{
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String contextPath = request.getContextPath();
        String cssUrl = contextPath + "/css/global-style.css";
        String css = "<link rel='stylesheet' type='text/css' href='"+cssUrl+"'>";
        String js = "<script src='js/validateInput.js'></script>";
        
        httpResponse.setHeader("Global-CSS", css+js);
        chain.doFilter(request, response);
        
        UtenteDAO u = new UtenteDAO();
        //u.doRetriveAll("").stream().forEach((e) -> System.out.println(e.toString()));
		System.out.println(request.getContextPath());
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}

}
