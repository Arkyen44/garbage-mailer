package servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

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
