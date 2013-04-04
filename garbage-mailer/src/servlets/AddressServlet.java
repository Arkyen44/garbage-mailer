package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.Data;
import classes.PMF;
import classes.Requete;

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
  		 data4.setMotDirecteur(nomRue);
  		 ArrayList<Data> dataparsee = data4.parsageAll();
  		 request.setAttribute("liste", dataparsee);
  		 request.setAttribute("num", num);
	  		for(Integer index = 0 ; index<dataparsee.size() ; index++){
				String rivoli = dataparsee.get(index).getRivoli();
				String typeRue = dataparsee.get(index).getTypeRue();
				String libelle = dataparsee.get(index).getLibelle();
				String commune = dataparsee.get(index).getCommune();
				String motDirecteur = dataparsee.get(index).getMotDirecteur();
				String statut = dataparsee.get(index).getStatut();
				String tenant = dataparsee.get(index).getTenant();
				String aboutissant = dataparsee.get(index).getAboutissant();
				String prestationCollecte = dataparsee.get(index).getPrestationCollecte();
				String typeCollecte = dataparsee.get(index).getTypeCollecte();
				String observationsPrestationCollecte = dataparsee.get(index).getObservationsPrestationCollecte();
				String bleuJourCollecte = dataparsee.get(index).getBleuJourCollecte();
				String jauneJourCollecte = dataparsee.get(index).getJauneJourCollecte();
				String observationsJourCollecte = dataparsee.get(index).getObservationsJourCollecte();
				String quartier = dataparsee.get(index).getQuartier();
				String observationsQuartier = dataparsee.get(index).getObservationsQuartier();
				// affichage des donnees 
				/*System.out.println("DONE!");
				System.out.println(rivoli + " " + libelle + "\n" + commune + motDirecteur + statut + "...");
				System.out.println(bleuJourCollecte);
				System.out.println(jauneJourCollecte);*/
			}
	     
	     
      	 RequestDispatcher rd = getServletContext().getRequestDispatcher("/chooseAddress.jsp");
         try {
			rd.forward(request,response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}
