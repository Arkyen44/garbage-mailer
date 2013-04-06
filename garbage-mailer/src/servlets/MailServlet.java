package servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import classes.Requete;

import beans.UserBean;

/**
 * Servlet pour envoyer les mails aux utilisateurs
 * @author Nico
 *
 */
public class MailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		//On récupère le jour
		Calendar calendar = new GregorianCalendar();
		int j = calendar.get(Calendar.DAY_OF_WEEK);
		String jour="";
		switch (j) {
		case 1: jour = "dimanche";
		case 2: jour = "lundi";
		case 3: jour = "mardi";
		case 4: jour = "mercredi";
		case 5: jour = "jeudi";
		case 6: jour = "vendredi";
		case 7: jour = "samedi";
		}

		System.out.println("nous sommes "+jour);
		
		/*
		 * 
		 * 
		 * TEST
		 * 
		 * 
		 * 
		 * */
		
		jour = "vendredi";
		
		//on récupère les personnes qui ont un ramassage de poubelle ce jour
		List<UserBean> listeBleue = new ArrayList<UserBean>();
		listeBleue = Requete.destinatairesBleu(jour);
		
		List<UserBean> listeJaune = new ArrayList<UserBean>();
		listeBleue = Requete.destinatairesJaune(jour);
		
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);

		String msgBody = "Test de l'envoi de mail";

		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("nicolas.dufour.ndr@gmail.com",
					"Example.com Admin"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
					"nicolas.dufour.ndr@gmail.com", "Mr. User"));
			msg.setSubject("Poubelle!");
			msg.setText(msgBody);
			Transport.send(msg);

		} catch (AddressException e) {
			// ...
		} catch (MessagingException e) {
			// ...
		}
		response.sendRedirect("index.jsp");
	}
}
