package beans;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.google.appengine.api.datastore.Key;
/**
 * Ce bean représente une habitation possédée par le user.
 * @author Nico
 *
 */
@PersistenceCapable
public class UserBean {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent
	private String name;
	@Persistent
	private String address;
	@Persistent
	private String numero;
	@Persistent
	private String rivolli;
	@Persistent
	private String jaune;
	@Persistent
	private String bleu;
	@Persistent
	private String triSac;
	

	public UserBean(){
		name="";
	}

	public String getName() {
		return name;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTriSac() {
		return triSac;
	}

	public void setTriSac(String triSac) {
		this.triSac = triSac;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}
	
	public String getJaune() {
		return jaune;
	}

	public void setJaune(String jaune) {
		this.jaune = jaune;
	}

	public String getBleu() {
		return bleu;
	}

	public void setBleu(String bleu) {
		this.bleu = bleu;
	}

	public String getRivolli() {
		return rivolli;
	}

	public void setRivolli(String rivolli) {
		this.rivolli = rivolli;
	}
	
	public void sendMail(String couleur){
		String msgBody = "";
		if (couleur.equals("bleue")){
			msgBody="Bonjour "+name.substring(0, name.indexOf("@"))+"! " +
					"Vos poubelles bleues vont êtres ramassées aujourd'hui, " +
					"n'oubliez pas de les sortir!";
		}else if (couleur.equals("jaune")){
			msgBody="Bonjour "+name.substring(0, name.indexOf("@"))+"! " +
					"Vos poubelles jaunes vont êtres ramassées aujourd'hui, " +
					"n'oubliez pas de les sortir!";
		}

		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		
		try {
			Message msg = new MimeMessage(session);
			try {
				msg.setFrom(new InternetAddress("nicolas.dufour.ndr@gmail.com",
						"Example.com Admin"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
						name, "Mr. User"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			msg.setSubject("Poubelle!");
			msg.setText(msgBody);
			Transport.send(msg);

		} catch (AddressException e) {
			// ...
		} catch (MessagingException e) {
			// ...
		}
		
		
	}

}
