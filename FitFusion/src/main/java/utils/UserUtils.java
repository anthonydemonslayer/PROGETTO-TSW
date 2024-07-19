package utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserUtils {
	/**
	 * Ritorna la pagina che l'utente sta visitando, nella forma paginaX.jsp
	 * @param request la HttpServletRequest della jsp
	 * @return paginaX.jsp
	 */
	public static String getVisitedJSP(HttpServletRequest request) {
		String fullPath = request.getServletPath();
		String fileName = fullPath.substring(fullPath.lastIndexOf("/") + 1);
        return fileName;
    }
	
}
