package utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserUtils {
	/**
	 * Ritorna true se l'utente � del tipo specificato da type
	 * @param session la sessione dell'utente
	 * @param type il tipo dell'utente
	 * @return risultato booleano
	 */
	public static Boolean isUserOfType(HttpSession session, String type) {
        String userType = (String) session.getAttribute("userType");
        if (userType == null) userType = "guest";
        return type.equals(userType);
    }
	
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
