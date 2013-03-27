package servlets;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.AddressBean;

import classes.PMF;
import classes.Requete;


public class AddressServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
		 System.out.println("dans AdressServlet");
		 //on récupère le quartier et le type
		 String typeRue = request.getParameter("ListeTypeRue");
	     String quartier = request.getParameter("ListeQuartier");
	     
	     //on récupère les adresses disponibles dans ce quartier
	     List<AddressBean> liste = Requete.getListAddress(quartier, typeRue);	  
	     
	     //on crée un attribut à la request, que l'on va forwarder
      	 request.setAttribute("liste", liste);
      	 RequestDispatcher rd = getServletContext().getRequestDispatcher("/addAddress2.jsp");
         try {
			rd.forward(request,response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}
