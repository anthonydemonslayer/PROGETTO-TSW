package control;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter(description = "Applica lo stile css di base a tutte le pagine del sito web", urlPatterns = { "/*" })
public class GlobalStylesheetFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	@Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException{
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String contextPath = request.getContextPath();
        String cssUrl = contextPath + "/css/global-style.css";
        
        httpResponse.setHeader("Global-CSS", "<link rel='stylesheet' type='text/css' href='"+cssUrl+"'>");
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}

}
