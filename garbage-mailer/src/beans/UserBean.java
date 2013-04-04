package beans;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

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

}
