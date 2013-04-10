package classes;

import java.util.ArrayList;

/**
 * Objet contenant deux listes de jours
 * La première pour les jours de distribution bleue
 * La seconde pour les jours de distribution jaune
 *  
 * @author Justine
 *
 */

public class Jours {
	private ArrayList<String> listeJoursBleu;
	private ArrayList<String> listeJoursJaune;
	
	/**
	 * Constructeur de Jour
	 */
	public Jours(){
		listeJoursBleu = new ArrayList<String>();
		listeJoursJaune = new ArrayList<String>();
	}
	
	/**
	 * Méthode permettant d'ajouter un jour bleu
	 * @param jourBleu
	 */
	public void addJourBleu(String jourBleu){
		this.listeJoursBleu.add(jourBleu);
	}
	
	/**
	 * Méthode permettant d'ajouter un jour jaune
	 * @param jourJaune
	 */
	public void addJourJaune(String jourJaune){
		this.listeJoursJaune.add(jourJaune);
	}
	
	/**
	 * Méthode renvoyant la liste des jours bleus
	 * @return
	 */
	public ArrayList<String> getJoursBleu(){
		return this.listeJoursBleu;
	}
	
	/**
	 * Méthode renvoyant la liste des jours jaunes
	 * @return
	 */
	public ArrayList<String> getJoursJaune(){
		return this.listeJoursJaune;
	}
}