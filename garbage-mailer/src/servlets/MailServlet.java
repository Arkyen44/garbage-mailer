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

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

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
		int s = calendar.get(Calendar.WEEK_OF_YEAR);
		
		boolean paire = ((s % 2)== 0);
		boolean impaire = ((s % 2)== 1);
		
		String jour="";
		String jour_special="";
		
		//Dans le switch, on décale les jours pour pouvoir envoyer un mail la veille
		switch (j) {
			case 1: {
				jour = "lundi";
				break;
			}
			case 2: {
				jour = "mardi";
				break;
			}
			case 3: {
				jour = "mercredi";
				if (paire){
					jour_special="merc_sem_paires";
				}else if (impaire){
					jour_special="merc_sem_impaires";
				}
				break;
			}
			case 4: {
				jour = "jeudi";
				
				break;
			}
			case 5: {
				jour = "vendredi";
				break;
			}
			case 6: {
				jour = "samedi";
				break;
			}
			case 7: {
				jour = "dimanche";
				break;
			}
		}
		
		//on récupère les personnes qui ont un ramassage de poubelle ce jour
		List<UserBean> listeBleue = new ArrayList<UserBean>();
		listeBleue = Requete.destinatairesBleu(jour);
		
		List<UserBean> listeJaune = new ArrayList<UserBean>();
		listeJaune = Requete.destinatairesJaune(jour);
		
		List<UserBean> listeBleueSpeciale = new ArrayList<UserBean>();
		List<UserBean> listeJauneSpeciale = new ArrayList<UserBean>();
		if (!jour_special.equals("")){
			//permet de récupérer les adresses dont les jours sont merc_sem_paires ou merc_sem_impaires
			listeBleueSpeciale = new ArrayList<UserBean>();
			listeBleueSpeciale = Requete.destinatairesBleu(jour_special);
			//permet de récupérer les adresses dont les jours sont merc_sem_paires ou merc_sem_impaires
			listeJauneSpeciale = new ArrayList<UserBean>();
			listeJauneSpeciale = Requete.destinatairesJaune(jour_special);
		}
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);

		String msgBody = "";
		
		if ((listeBleue != null) && (listeBleue.size()>0)){
			for (UserBean u : listeBleue){
				msgBody="Bonjour "+u.getName().substring(0, u.getName().indexOf("@"))+"! " +
						"Vos poubelles bleues vont êtres ramassées demain, " +
						"dans la rue " + u.getAddress()+
						" n'oubliez pas de les sortir!" +
						"\n\n\n\n\n\n Je ne souhaite plus recevoir de mail concernant cette adresse : " +
						"http://garbage-mailer.appspot.com/delAddress?idDel="+u.getRivolli();
				try {
					Message msg = new MimeMessage(session);
					msg.setFrom(new InternetAddress("nicolas.dufour.ndr@gmail.com",
							"http://garbage-mailer.appspot.com"));
					msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
							u.getName(), u.getName().substring(0, u.getName().indexOf("@"))));
					msg.setSubject("Ramassage de vos poubelles!");
					msg.setText(msgBody);
					Transport.send(msg);
	
				} catch (AddressException e) {
					// ...
				} catch (MessagingException e) {
					// ...
				}
			}
		}
		
		
		
		if ((listeJaune != null) && (listeJaune.size()>0)){
			for (UserBean u : listeJaune){
				msgBody="Bonjour "+u.getName().substring(0, u.getName().indexOf("@"))+"! " +
						"Vos poubelles jaunes vont êtres ramassées demain, " +
						"dans la rue " + u.getAddress()+
						" n'oubliez pas de les sortir!" +
						"\n\n\n\n\n\n Je ne souhaite plus recevoir de mail concernant cette adresse : " +
						"http://garbage-mailer.appspot.com/delAddress?idDel="+u.getRivolli();
				try {
					Message msg = new MimeMessage(session);
					msg.setFrom(new InternetAddress("nicolas.dufour.ndr@gmail.com",
							"http://garbage-mailer.appspot.com"));
					msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
							u.getName(), u.getName().substring(0, u.getName().indexOf("@"))));
					msg.setSubject("Ramassage de vos poubelles!");
					msg.setText(msgBody);
					Transport.send(msg);
	
				} catch (AddressException e) {
					// ...
				} catch (MessagingException e) {
					// ...
				}
			}
		}
		
		
		//Cette boucle concerne uniquement les mercredis (merc_sem_paires et merc_sem_impaires)
		if (jour.equals("mercredi")){
			if ((listeBleueSpeciale != null)&&(listeBleueSpeciale.size()>0)){
				for (UserBean u : listeBleueSpeciale){
					msgBody="Bonjour "+u.getName().substring(0, u.getName().indexOf("@"))+"! " +
							"Vos poubelles bleues vont êtres ramassées demain, " +
							"dans la rue " + u.getAddress()+
							" n'oubliez pas de les sortir!" +
							"\n\n\n\n\n\n Je ne souhaite plus recevoir de mail concernant cette adresse : " +
							"http://garbage-mailer.appspot.com/delAddress?idDel="+u.getRivolli();
					try {
						Message msg = new MimeMessage(session);
						msg.setFrom(new InternetAddress("nicolas.dufour.ndr@gmail.com",
								"http://garbage-mailer.appspot.com"));
						msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
								u.getName(), u.getName().substring(0, u.getName().indexOf("@"))));
						msg.setSubject("Ramassage de vos poubelles!");
						msg.setText(msgBody);
						Transport.send(msg);
		
					} catch (AddressException e) {
						// ...
					} catch (MessagingException e) {
						// ...
					}
				}
			}
			
			if ((listeJauneSpeciale != null)&&(listeJauneSpeciale.size()>0)){
				for (UserBean u : listeJauneSpeciale){
					msgBody="Bonjour "+u.getName().substring(0, u.getName().indexOf("@"))+"! " +
							"Vos poubelles jaunes vont êtres ramassées demain, " +
							"dans la rue " + u.getAddress()+
							" n'oubliez pas de les sortir!" +
							"\n\n\n\n\n\n Je ne souhaite plus recevoir de mail concernant cette adresse : " +
							"http://garbage-mailer.appspot.com/delAddress?idDel="+u.getRivolli();
					try {
						Message msg = new MimeMessage(session);
						msg.setFrom(new InternetAddress("nicolas.dufour.ndr@gmail.com",
								"http://garbage-mailer.appspot.com"));
						msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
								u.getName(), u.getName().substring(0, u.getName().indexOf("@"))));
						msg.setSubject("Ramassage de vos poubelles!");
						msg.setText(msgBody);
						Transport.send(msg);
		
					} catch (AddressException e) {
						// ...
					} catch (MessagingException e) {
						// ...
					}
				}
			}
		}
		
		
		response.sendRedirect("index.jsp");
	}
}
