package classes;

import java.util.ArrayList;

/**
 * Cet objet représente la plage de jours pour laquelle les poubelles
 * passent à certains numéros d'adresse.
 * 
 * Sur le fichier csv, il y a 2 plages d'adresses:
 * 1) une plage allant de 0 jusqu'à un certain numéro pair et 
 * de 1 jusqu'à un certain numéro impair
 * 2) et une plage allant d'un certain numéro pair à "l'infini"(que nous avons fixée à 2000)
 * et d'un certain numéro impair à "l'infini" (que nous avons fixée à 1999)
 * 
 *  A chaque plage d'adresse est associée une plage de jours pour laquelle
 *  les poubelles bleues passent. 
 * 
 * @author Justine
 *
 */

public class PlageJour {

	public Integer debutPair1 = 0;
	public Integer finPair1 = 0;
	public Integer debutImpair1 = 1;
	public Integer finImpair1 = 0;
	
	public ArrayList<String> Jours1 = new ArrayList<String>();
	
	public Integer debutPair2 = 0;
	public Integer finPair2 = 0;
	public Integer debutImpair2 = 0;
	public Integer finImpair2 = 0;
	
	public ArrayList<String> Jours2 = new ArrayList<String>();

}
