package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import classes.Data;
import classes.*;

/**
 * parsage du fichier et validation de l'existence de l'adresse
 * @author Nico
 *
 */
public class AddressServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
		
		 String num = "";
		 String nomRue = "";
		 //on récupère le nom de la rue
		 nomRue = request.getParameter("nomRue");
		 num = request.getParameter("num");
		 
		//On vérifie que les 2 champs du formulaire sont bien remplis
		 if ((nomRue.equals("")) || (num.equals(""))){
				 response.sendRedirect("index.jsp");
		 }
		//et que num est bien un chiffre
		 if (! num.matches("[0-9]*"))
			 response.sendRedirect("index.jsp");
		
		 System.out.println("-"+nomRue);
		 System.out.println("-"+num);
		 
  		 Data data4 = new Data("http://data.nantes.fr/api/publication/JOURS_COLLECTE_DECHETS_VDN/JOURS_COLLECTE_DECHETS_VDN_STBL/content/?format=csv");
  		 ArrayList<Data> dataparsee = data4.parsageFirst(nomRue);
  		 request.setAttribute("liste", dataparsee);
  		 request.setAttribute("num", num);
	  		
  	
      	 RequestDispatcher rd = getServletContext().getRequestDispatcher("/chooseAddress.jsp");
         try {
			rd.forward(request,response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}
