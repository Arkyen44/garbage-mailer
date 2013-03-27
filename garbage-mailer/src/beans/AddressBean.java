package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class AddressBean implements Serializable{
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent
	private String quartier;	
	@Persistent
	private String type;
	@Persistent
	private String nomRue;
	@Persistent
	private List<String> bleu;
	@Persistent
	private List<String> jaune;
	@Persistent
	private String rivolli;
	
	
	public String getRivolli() {
		return rivolli;
	}


	public void setRivolli(String rivolli) {
		this.rivolli = rivolli;
	}


	public List<String> getBleu() {
		return bleu;
	}


	public void setBleu(List<String> bleu) {
		this.bleu = bleu;
	}


	public List<String> getJaune() {
		return jaune;
	}


	public void setJaune(List<String> jaune) {
		this.jaune = jaune;
	}


	public AddressBean() {
		
	}
	
	
	public String getQuartier() {
		return quartier;
	}
	public void setQuartier(String quartier) {
		this.quartier = quartier;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNomRue() {
		return nomRue;
	}
	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}
	public Key getKey() {
		return key;
	}


	public void setKey(Key key) {
		this.key = key;
	}
	 
}
