package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Data;
import classes.PMF;

import beans.UserBean;


public class LoadAddressFromCsvServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
		System.out.println("dans load"); 
		/*
		Data data4 = new Data("http://data.nantes.fr/api/publication/JOURS_COLLECTE_DECHETS_VDN/JOURS_COLLECTE_DECHETS_VDN_STBL/content/?format=csv");
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	    	for(Integer index = 0 ; index<data4.parsageAll().size() ; index++){
				String rivoli = data4.parsageAll().get(index).getRivoli();
				String libelle = data4.parsageAll().get(index).getLibelle();
				String commune = data4.parsageAll().get(index).getCommune();
				String motDirecteur = data4.parsageAll().get(index).getMotDirecteur();
				String statut = data4.parsageAll().get(index).getStatut();
				String tenant = data4.parsageAll().get(index).getTenant();
				String aboutissant = data4.parsageAll().get(index).getAboutissant();
				String prestationCollecte = data4.parsageAll().get(index).getPrestationCollecte();
				String typeCollecte = data4.parsageAll().get(index).getTypeCollecte();
				String observationsPrestationCollecte = data4.parsageAll().get(index).getObservationsPrestationCollecte();
				ArrayList<String> bleuJourCollecte = data4.parsageAll().get(index).getBleuJourCollecte();
				ArrayList<String> jauneJourCollecte = data4.parsageAll().get(index).getJauneJourCollecte();
				String observationsJourCollecte = data4.parsageAll().get(index).getObservationsJourCollecte();
				ArrayList<String> quartier = data4.parsageAll().get(index).getQuartier();
				String observationsQuartier = data4.parsageAll().get(index).getObservationsQuartier();
				 ajout de la ligne de la BD avec les champs récupéré 
				
				AddressBean a1 = new AddressBean();
				a1.setNomRue(libelle);
				//a1.setQuartier();
				//a1.setType();
				//a1.setRivolli(rivoli);
				
				//pm.makePersistent(a2);*/
		/*	}
	    	
	       
	    } finally {
	        pm.close();
	    }
		
		*/
		
		
		//création de fausses adresses
		/*AddressBean a1 = new AddressBean();
		a1.setNomRue("Passage Alvar Aalto");
		a1.setQuartier("Dervallieres - Zola");
		a1.setType("Passage");
		a1.setRivolli("0200");
		
		AddressBean a2 = new AddressBean();
		a2.setNomRue("Impasse de l'Abbaye");
		a2.setQuartier("Bellevue - Chantenay - Sainte Anne");
		a2.setType("Impasse");
		a2.setRivolli("0010");
		
		AddressBean a3 = new AddressBean();
		a3.setNomRue("Impasse Aguesse");
		a3.setQuartier("Dervallieres - Zola");
		a3.setType("Impasse");
		a3.setRivolli("0052");
		
		AddressBean a4 = new AddressBean();
		a4.setNomRue("Passage Saint Aignan");
		a4.setQuartier("Dervallizees - Zola");
		a4.setType("Passage");
		a4.setRivolli("7527");
		
		AddressBean a5 = new AddressBean();
		a5.setNomRue("Passage Berthault");
		a5.setQuartier("Centre Ville");
		a5.setType("Passage");
		a5.setRivolli("0801");
		
		AddressBean a6 = new AddressBean();
		a6.setNomRue("Rue de la Bertinière");
		a6.setQuartier("Nantes Erdre");
		a6.setType("Rue");
		a6.setRivolli("0808");
		
		AddressBean a7 = new AddressBean();
		a7.setNomRue("Avenue d'Hestia");
		a7.setQuartier("Nantes Sud");
		a7.setType("Avenue");
		a7.setRivolli("4195");
		
		AddressBean a8 = new AddressBean();
		a8.setNomRue("Rue des Hêtres");
		a8.setQuartier("Nantes Nord");
		a8.setType("Rue");
		a8.setRivolli("4196");
		
		AddressBean a9 = new AddressBean();
		a9.setNomRue("Chemin de la Hunaudais");
		a9.setQuartier("Dervallieres - Zola");
		a9.setType("Chemin");
		a9.setRivolli("4259");
		
		AddressBean a10 = new AddressBean();
		a10.setNomRue("Rue de la Hunaudais");
		a10.setQuartier("Dervallieres - Zola");
		a10.setType("Rue");
		a10.setRivolli("4259");
		
		AddressBean a11 = new AddressBean();
		a11.setNomRue("Rue Jean Huss");
		a11.setQuartier("Dervallieres - Zola");
		a11.setType("Rue");
		a11.setRivolli("4460");
		
		AddressBean a12 = new AddressBean();
		a12.setNomRue("Boulevard Jean Ingres");
		a12.setQuartier("Dervallieres - Zola");
		a12.setType("Boulevard");
		a12.setRivolli("4464");
		
		UserBean u1 = new UserBean();
		u1.setName("nicolas.dufour.ndr@gmail.com");
		u1.setAddress(a1.getNomRue());
		
		UserBean u2 = new UserBean();
		u2.setName("toto@gmail.com");
		u2.setAddress(a2.getNomRue());
		
		UserBean u3 = new UserBean();
		u3.setName("tata@gmail.com");
		u3.setAddress(a3.getNomRue());
		
		//insertion en BDD 
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	    	pm.makePersistent(a1);
	    	pm.makePersistent(a2);
	    	pm.makePersistent(a3);
	    	pm.makePersistent(a4);
	    	pm.makePersistent(a5);
	    	pm.makePersistent(a6);
	    	pm.makePersistent(a7);
	    	pm.makePersistent(a8);
	    	pm.makePersistent(a9);
	    	pm.makePersistent(a10);
	    	pm.makePersistent(a11);
	    	pm.makePersistent(a12);
	    	
	    	pm.makePersistent(u1);
	    	pm.makePersistent(u2);
	    	pm.makePersistent(u3);
	       
	    } finally {
	        pm.close();
	    }
	    response.sendRedirect("/index.jsp");*/
	 }
}