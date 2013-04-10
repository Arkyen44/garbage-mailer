package servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import classes.Requete;

/**
 * Suppression de tuple (adresse, nomUtilisateur) en base de donnée
 * @author Nico
 *
 */
public class DelAddressServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
		UserService userService = UserServiceFactory.getUserService();
		User userGoogle = userService.getCurrentUser();
		
		String rivolli = request.getParameter("idDel");
		
		if (rivolli.length() == 3) rivolli = "0"+rivolli;
		if (rivolli.length() == 2) rivolli = "00"+rivolli;
		if (rivolli.length() == 1) rivolli = "000"+rivolli;
		
		Requete.delAddress(rivolli, userGoogle.getEmail());
		//forcer le rafraichissement de la page index (sans ça, l'adresse ne supprime pas du premier coup)
		response.addHeader("Pragma", "no-cache");
		response.addHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.addHeader("Cache-Control", "must-revalidate");
		response.sendRedirect("index.jsp");
	}
	
}
