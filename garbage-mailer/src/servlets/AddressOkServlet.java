package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserBean;
//import classes.Data;
//import classes.Jours;
//import classes.PMF;
//import classes.Requete;
import classes.*;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

/**
 * L'adresse a été validée préalablement.
 * Cette servlet va vérifier que l'adresse saisie n'est pas déjà en base de données.
 * Si elle n'y est pas, elle est ajoutée.
 * @author Nico
 *
 */
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
		
		if (idRue.length() == 3) idRue = "0"+idRue;
		if (idRue.length() == 2) idRue = "00"+idRue;
		if (idRue.length() == 1) idRue = "000"+idRue;
		
		Data data4 = new Data("http://data.nantes.fr/api/publication/JOURS_COLLECTE_DECHETS_VDN/JOURS_COLLECTE_DECHETS_VDN_STBL/content/?format=csv");
		Jours jours = data4.parsageSecond(idRue,Integer.parseInt(num));//bien penser Ã  mettre le rivoli sur 4 chiffres
		ArrayList<String> joursBleu = jours.getJoursBleu();
		ArrayList<String> joursJaune = jours.getJoursJaune();

		String bleu = "";
		String jaune = "";
		
		for(String jour : joursBleu){
			bleu += jour+" ";
		}
		for(String jour : joursJaune){
			jaune += jour+" ";
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
				ub.setBleu(bleu);
				ub.setJaune(jaune);
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
