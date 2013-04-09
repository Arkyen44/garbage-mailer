package classes;

import java.util.ArrayList;

public class ObservationsParsage {
	
	private String observation;
	
	public ObservationsParsage(String observation){
		this.observation = observation;
	}
	
	public PlageNum determinePlageNum(){ //fonction qui parse observationPrestationCollecte
		PlageNum plageNum = new PlageNum();
		//A DEVELOPPER (avec regex)
		return plageNum;
	}
	
	public PlageJour determinePlageJour(){ //fonction qui parse observationJourCollecte
		PlageJour plageJour = new PlageJour();
		//la chaine est de type : 
		//jusqu'aux numeros [numImpair] et [numPair] : [jour1/jour2] ; A partir des numéros : [numImpair] et [numPair] : [jour1/jour2]
		//ou
		//jusqu'aux numeros [numImpair] et [numPair] : [jour1/jour2] ; numéros pairs a partir du : [numPair] : [jour1/jour2]
		//ou
		//jusqu'aux numeros [numImpair] et [numPair] : [jour1/jour2] ; numéros impairs a partir du : [numImPair] : [jour1/jour2]
		
		//splitt du "jusqu'au"
		String[] observationSplittee = this.observation.split(";");
		String [] jusquau = observationSplittee[0].split(" ");
		//recuperation du ou des jours
		String[] jours1 = observationSplittee[0].split(":")[1].split(" ")[1].split("/");
		for(String jour : jours1){
			plageJour.Jours1.add(jour);
		}
		
		//recuperation des numeros d'adresse
		Boolean numImpairTrouve = false;
		for(String mot : jusquau){
			try {
				Integer.parseInt(mot);
				if(!numImpairTrouve){
					numImpairTrouve = true;
					plageJour.finImpair1 = Integer.parseInt(mot);
				}
				else{
					plageJour.finPair1 = Integer.parseInt(mot);
				}
			} catch (NumberFormatException e){
			}
		}
		
		//splitt du "à partir de"
		String [] apartirde = observationSplittee[1].split(" ");
		//recuperation du ou des jours
		String[] jours2 = observationSplittee[1].split(":")[1].split(" ")[1].split("/");
		for(String jour : jours2){
			plageJour.Jours2.add(jour);
		}
		
		Boolean pair = false;
		Boolean impair = false;
		//si "numéros pairs à partir de"
		for(String mot : apartirde){
			if(mot.equals("pairs")){
				pair = true;
			}
			if(pair){
				try {
					Integer.parseInt(mot);
					plageJour.debutPair2 = Integer.parseInt(mot);
					plageJour.finPair2 = 1000;
					plageJour.debutImpair2 = 0;
					plageJour.finImpair2 = 0;
				} catch (NumberFormatException e){
				}
			}
		}

		//si "numéros impairs à partir de"
		if(!pair){
			for(String mot : apartirde){
				if(mot.equals("impairs")){
					impair = true;
				}
				if(impair){
					try {
						Integer.parseInt(mot);
						plageJour.debutImpair2 = Integer.parseInt(mot);
						plageJour.finImpair2 = 999;
						plageJour.debutPair2 = 0;
						plageJour.finPair2 = 0;
					} catch (NumberFormatException e){
					}
				}
			}
			
		}
		//si "à partir de"
		if(!pair && !impair){
			Boolean pairTrouve = false;
			for(String mot : apartirde){
				if(!pairTrouve){
					try {
						Integer.parseInt(mot);
						pairTrouve = true;
						plageJour.debutPair2 = Integer.parseInt(mot);
						plageJour.finPair2 = 1000;
					} catch (NumberFormatException e){
					}
				}
				else{
					try {
						Integer.parseInt(mot);
						pairTrouve = true;
						plageJour.debutImpair2 = Integer.parseInt(mot);
						plageJour.finImpair2 = 999;
					} catch (NumberFormatException e){
					}
				}
			}
			
		}
		
		return plageJour;
	}

}
