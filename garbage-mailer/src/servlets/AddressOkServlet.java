package servlets;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Redirect;

import beans.AddressBean;
import beans.UserBean;
import classes.PMF;
import classes.Requete;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Transaction;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class AddressOkServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
		
		//booléen indiquant si l'utilisateur a déjà ajouté l'adresse qu'il va ajouter
		boolean alreadyHave = false;
		
		//on récupère l'adresse qui a été validée en BDD
		AddressBean address = Requete.getAddress(request.getParameter("ListeRue"));
		
		//On récupère le user en BDD
		UserService userService = UserServiceFactory.getUserService();
		User userGoogle = userService.getCurrentUser();
		
		
		//on regarde si l'utilisateur n'a pas déjà inséré cette adresse
		List<UserBean> liste = Requete.getUser(userGoogle.getNickname());
		
		//si la liste n'est pas nulle, c'est que l'utilisateur a déjà au moins une adresse
		if (liste !=null){
			//on vérifie que ce ne soit pas celle qu'il est en train d'ajouter
			for (UserBean ub : liste){
				if (ub.getAddress().equals(address.getNomRue())) {
					alreadyHave = true;
				}
			}
		}
		
		
		
		//on sauv la nouvelle addresse
		if (!alreadyHave){
			UserBean ub = new UserBean();
			ub.setAddress(address.getNomRue());
			ub.setName(userGoogle.getEmail());
			
			PersistenceManager pm = PMF.get().getPersistenceManager();
			
		    try {
		    	pm.makePersistent(ub);
		    } finally {
		        pm.close();
		    }
		}
		
	    /*RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        try {
			rd.forward(request,response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//forcer le rafraichissement de la page index (sans ça, l'adresse ne s'affiche pas du premier coup)
		response.addHeader("Pragma", "no-cache");
		response.addHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.addHeader("Cache-Control", "must-revalidate");
		response.sendRedirect("index.jsp");
	}
		
}
