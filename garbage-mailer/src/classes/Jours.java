package classes;

import java.util.ArrayList;

public class Jours {
	private ArrayList<String> listeJoursBleu;
	private ArrayList<String> listeJoursJaune;
	
	public Jours(){
		listeJoursBleu = new ArrayList<String>();
		listeJoursJaune = new ArrayList<String>();
	}
	
	public void addJourBleu(String jourBleu){
		this.listeJoursBleu.add(jourBleu);
	}
	
	public void addJourJaune(String jourJaune){
		this.listeJoursJaune.add(jourJaune);
	}
	
	public ArrayList<String> getJoursBleu(){
		return this.listeJoursBleu;
	}
	
	public ArrayList<String> getJoursJaune(){
		return this.listeJoursJaune;
	}
}