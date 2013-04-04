package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserBean;
import classes.Data;
import classes.PMF;
import classes.Requete;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class AddressOkServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
		
		//booléen indiquant si l'utilisateur a déjà ajouté l'adresse qu'il va ajouter
		boolean alreadyHave = false;
		
		//on récupère l'adresse qui a été validée en BDD
		String idRue = request.getParameter("choixAdresse");
		String num = request.getParameter("numRue");
		
		HttpSession sess =request.getSession(true);
		ArrayList<Data> dataToChoose = ((ArrayList<Data>)sess.getAttribute("listeData"));
		Data address = null;
		
		if (dataToChoose != null){
			for (Data d : dataToChoose){
				if (d.getRivoli().equals(idRue)){
					address = d;
					break;
				}
					
			}
		}
		//On récupère le nom de l'utilisateur connecté à google
		UserService userService = UserServiceFactory.getUserService();
		User userGoogle = userService.getCurrentUser();		
		
		if (address != null){
			//on regarde si l'utilisateur n'a pas déjà inséré cette adresse
			if (! Requete.exist(userGoogle.getEmail(), idRue, num)){
				//on insère l'adresse
				UserBean ub = new UserBean();
				ub.setName(userGoogle.getEmail());
				ub.setNumero(num);
				ub.setAddress(address.getLibelle());
				ub.setRivolli(address.getRivoli());
				ub.setBleu(address.getBleuJourCollecte());
				ub.setJaune(address.getJauneJourCollecte());
				PersistenceManager pm = PMF.get().getPersistenceManager();
			    try {
			    	pm.makePersistent(ub);
			    } finally {
			        pm.close();
			    }
			}
		}
		
		//forcer le rafraichissement de la page index (sans ça, l'adresse ne s'affiche pas du premier coup)
		response.addHeader("Pragma", "no-cache");
		response.addHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.addHeader("Cache-Control", "must-revalidate");
		response.sendRedirect("index.jsp");
	}
		
}
