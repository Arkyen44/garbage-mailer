package classes;

import java.util.ArrayList;

/**
 * Objet représentant une plage de numéros d'adresses
 * Elle est constituée d'un intervalle de numéros d'adresse pairs,
 * d'un  intervalle de numéros d'adresse impairs,
 * ainsi que des numéros d'adresses supplémentaires et des numéros exclus.
 * 
 * Cet objet sera utile pour déterminer si l'adresse de l'utilisateur
 * correspond bien à la ligne du fichier csv.
 * 
 * @author Justine
 *
 */

public class PlageNum {
	public Integer debutPair = 0;
	public Integer finPair = 0;
	public Integer debutImpair = 0;
	public Integer finImpair = 0;
	public ArrayList<Integer> numerosSupplementaires = new ArrayList<Integer>();
	public ArrayList<Integer> numerosExclus = new ArrayList<Integer>();
}
