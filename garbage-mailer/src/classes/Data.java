package classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Data implements Serializable{
	private String rivoli;
	private String typeRue;
	private String libelle;
	private String commune;
	private String motDirecteur;
	private String statut;
	private String tenant;
	private String aboutissant;
	private String prestationCollecte;
	private String typeCollecte;
	private String observationsPrestationCollecte;
	private String bleuJourCollecte;
	private String jauneJourCollecte;
	private String observationsJourCollecte;
	private String quartier;
	private String observationsQuartier;

	private String urlFichier;


	
	public Data(String urlFichier){
		this.rivoli = "";
		this.typeRue = "";
		this.libelle = "";
		this.commune = "";
		this.motDirecteur = "";
		this.statut = "";
		this.tenant = "";
		this.aboutissant = "";
		this.prestationCollecte = "";
		this.typeCollecte = "";
		this.observationsPrestationCollecte = "";
		this.bleuJourCollecte = "";
		this.jauneJourCollecte = "";
		this.observationsJourCollecte = "";
		this.quartier = "";
		this.observationsQuartier = "";
		
		this.urlFichier = urlFichier;
	}
	
	public void setRivoli(String string){
		this.rivoli = string;
	}
	
	public void setTypeRue(String string){
		this.typeRue = string;
	}
	
	public void setLibelle(String string){
		this.libelle = string;
	}
	
	public void setCommune(String string){
		this.commune = string;
	}
	
	public void setMotDirecteur(String string){
		this.motDirecteur = string;
	}
	
	public void setStatut(String string){
		this.statut = string;
	}
	
	public void setTenant(String string){
		this.tenant = string;
	}
	
	public void setAboutissant(String string){
		this.aboutissant = string;
	}
	
	public void setPrestationCollecte(String string){
		this.prestationCollecte = string;
	}
	
	public void setTypeCollecte(String string){
		this.typeCollecte = string;
	}
	
	public void setObservationsPrestationCollecte(String string){
		this.observationsPrestationCollecte = string;
	}
	
	public void setBleuJourCollecte(String string){
		this.bleuJourCollecte += " " + string;
	}
	
	public void setJauneJourCollecte(String string){
		this.jauneJourCollecte += " " + string;
	}
	
	public void setObservationsJourCollecte(String string){
		this.observationsJourCollecte = string;
	}
	
	public void setQuartier(String string){
		this.quartier = string;
	}
	
	public void setObservationsQuartier(String string){
		this.observationsQuartier = string;
	}

	public String getRivoli(){
		return this.rivoli;
	}
	
	public String getTypeRue(){
		return this.typeRue;
	}
	
	public String getLibelle(){
		return this.libelle;
	}
	
	public String getCommune(){
		return this.commune;
	}
	
	public String getMotDirecteur(){
		return this.motDirecteur;
	}
	
	public String getStatut(){
		return this.statut;
	}
	
	public String getTenant(){
		return this.tenant;
	}
	
	public String getAboutissant(){
		return this.aboutissant;
	}
	
	public String getPrestationCollecte(){
		return this.prestationCollecte;
	}
	
	public String getTypeCollecte(){
		return this.typeCollecte;
	}
	
	public String getObservationsPrestationCollecte(){
		return this.observationsPrestationCollecte;
	}
	
	public String getBleuJourCollecte(){
		return this.bleuJourCollecte;
	}
	
	public String getJauneJourCollecte(){
		return this.jauneJourCollecte;
	}
	
	public String getObservationsJourCollecte(){
		return this.observationsJourCollecte;
	}
	
	public String getQuartier(){
		return this.quartier;
	}
	
	public String getObservationsQuartier(){
		return this.observationsQuartier;
	}
	
	public String getUrlFichier(){
		return this.urlFichier;
	}

	public void resetData(){
		this.rivoli = "";
		this.typeRue = "";
		this.libelle = "";
		this.commune = "";
		this.motDirecteur = "";
		this.statut = "";
		this.tenant = "";
		this.aboutissant = "";
		this.prestationCollecte = "";
		this.typeCollecte = "";
		this.observationsPrestationCollecte = "";
		this.bleuJourCollecte = "";
		this.jauneJourCollecte = "";
		this.observationsJourCollecte = "";
		this.quartier = "";
		this.observationsQuartier = "";
	}
	
	/**
	 * Fonction parsageFirst qui servira a parser tout le fichier
	 * pour trouver l'adresse recherchee par le visiteur
	 * Elle renvoie une liste d'adresses succeptible de comprendre celle recherchee
	 */
	public ArrayList<Data> parsageFirst(String motDirecteur){
		this.setMotDirecteur(motDirecteur);
		ArrayList<Data> dataLine = new ArrayList<Data>();
		try {
			//on parcourt le fichier csv present sur le serveur de l'openData grace a son URL
			URL url = new URL(this.getUrlFichier());
			HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
			httpConnection.connect();
			InputStreamReader isr = new InputStreamReader(httpConnection.getInputStream());
			BufferedReader reader = new BufferedReader(isr);
			
			String line = "";
			//pour chaque ligne du fichier
			while ((line = reader.readLine()) != null) {
				//on splitte chaque champs avec , qui est le délimiteur du csv
				StringTokenizer splitter = new StringTokenizer(line, ",");
				//on cree un objet pour stocker les informations de la ligne
				Data datas = new Data(this.getUrlFichier());
				
				Boolean trouve = false; //a-t-on trouve une adresse s'approchant de l'adresse recherchee?
				
				for(Integer i=0; splitter.hasMoreTokens() ;i++){ //pour chaque champs
					String data = (String) splitter.nextToken(); //on le recupere dans une chaine de caracteres
					data = data.replace("\"", ""); //on enleve les guillemets
					switch(i){
					
						case 0://rivoli
							if(!(data.isEmpty())){
								datas.setRivoli(data); //on enregistre le rivoli
							}
							break;
							
						case 1://libelle
							if(!(data.isEmpty())){
								String[] splitterLibelle = data.split(" ");
								datas.setTypeRue(splitterLibelle[0]); // on enregistre le type de rue (au cas ou on voudrait changer la recherche par la suite)
								datas.setLibelle(data);
							}
							break;
							
						case 2://commune
							if(!(data.isEmpty())){
								datas.setCommune(data);
							}
							break;
							
						case 3://controle motDirecteur
							if(!(data.isEmpty())){
								datas.setMotDirecteur(data);
							}
							if(!(this.motDirecteur.equals(""))){ //si on fait la recherche par le mot directeur
								String[] splitterMotDirecteur = this.motDirecteur.toUpperCase().split(" "); //on enleve la casse
								
								for(String s : splitterMotDirecteur){
									//on enleve les eventuelles apostrophes
									if (s.matches(".*'.*"))
										s = s.split("'")[1];
									String s1 = StringOperation.sansAccent(s);
									String data1 = StringOperation.sansAccent(data);
									
									if(data1.toUpperCase().equals(s1)){
										trouve = true;
									}
								}
							}
							break;
							
						case 4://statut
							if(!(data.isEmpty())){
								datas.setStatut(data);
							}
							break;
							
						case 5://tenant
							if(!(data.isEmpty())){
								datas.setTenant(data);
							}
							break;
							
						case 6://aboutissant
							if(!(data.isEmpty())){
								datas.setAboutissant(data);
							}
							break;
							
						case 7://prestationCollecte
							if(!(data.isEmpty())){
								datas.setPrestationCollecte(data);
							}
							break;
							
						case 8://typeCollecte
							if(!(data.isEmpty())){
								datas.setTypeCollecte(data);
							}
							break;
							
						case 9://observationsPrestationCollecte
							if(!(data.isEmpty())){
								datas.setObservationsPrestationCollecte(data);
							}
							break;
							
						case 10://bleuJourCollecte
							if(!(data.isEmpty())){
								//on recupere les jours en enlevant les et et les -
								String[] splitterBleu1 = data.split(" et ");
								for(String data1 : splitterBleu1){
									String[] splitterBleu2 = data1.split(" - ");
									for(String data2 : splitterBleu2){
										datas.setBleuJourCollecte(data2);
									}
								}
							}
							break;
							
						case 11://jauneJourCollecte
							if(!(data.isEmpty())){
								String[] splitterJaune1 = data.split(" et ");
								for(String data1 : splitterJaune1){
									String[] splitterJaune2 = data1.split(" - ");
									for(String data2 : splitterJaune2){
										datas.setJauneJourCollecte(data2);
									}
								}
							}
							break;
							
						case 12://observationsJourCollecte
							if(!(data.isEmpty())){
								datas.setObservationsJourCollecte(data);
							}
							break;
							
						case 13://quartier
							if(!(data.isEmpty())){
								datas.setQuartier(data);
							}
							break;
							
						case 14://observationsQuartier
							if(!(data.isEmpty())){
								datas.setObservationsQuartier(data);
							}
							break;
					}
				}
				if(trouve){ //si la ligne parcourue peut correspondre a l'adresse recherchee 
					dataLine.add(datas); //on ajoute l'adresse a la liste d'adresses potentielles
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataLine;
	}
	
	/**
	 * Fonction parsageSecond qui servira à rechercher les jours de collecte 
	 * pour les poubelles bleus et jaunes
	 * Elle renverra un objet Jours comprenant deux attributs de type ArrayList<Integer>
	 * contenant respectivement les jours de collecte pour les poubelles et
	 * les jours de collectes pour les poubelles jaunes
	 * en fonction du rivoli de l'adresse de l'utilisateur ainsi que de son numero de logement
	 */
	public Jours parsageSecond(String rivoli,Integer numAdresse){
		this.setRivoli(rivoli);
		//renseignements sur le numAdresse
		Boolean numAdresse_est_pair = false;
		if(numAdresse%2 == 0){
			numAdresse_est_pair = true;
		}
		
		Jours jours = new Jours();
		try {
			URL url = new URL(this.getUrlFichier());
			HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
			httpConnection.connect();
			InputStreamReader isr = new InputStreamReader(httpConnection.getInputStream());
			BufferedReader reader = new BufferedReader(isr);
			
			String line = "";
			//pour chaque ligne
			while ((line = reader.readLine()) != null) {
				StringTokenizer splitter = new StringTokenizer(line, ",");
				Boolean rivoli_trouve = false;
				Boolean ligne_trouvee = false;
				Boolean bleusMixte = false;
				
				for(Integer i=0; splitter.hasMoreTokens() ;i++){
					Boolean bleuESTjaune = false;
					Boolean obsPresColAparser = false;
					String data = (String) splitter.nextToken();
					data = data.replace("\"", "");
					switch(i){
					
						case 0://controle rivoli
							if( !(data.isEmpty()) && (this.getRivoli() != "") && (data.equals(this.getRivoli())) ){
								rivoli_trouve = true;
							}
							break;
							
						case 1://libelle
							break;
							
						case 2://commune
							break;
							
						case 3://motDirecteur
							break;
							
						case 4://statut
							break;
							
						case 5://tenant
							break;
							
						case 6://aboutissant
							break;
							
						case 7://controle prestationCollecte
							if( !(data.isEmpty()) && rivoli_trouve ){
								if(data.replaceAll("'","").equals("TRISAC") ||
										data.equals("Centre-ville en C3") ||
										data.equals("extension trisac 2013")){
									bleuESTjaune = true;
								}
							}
							break;
							
						case 8://controle typeCollecte
							if( !(data.isEmpty()) && rivoli_trouve ){
								if(data.equals("pluriel")){
									obsPresColAparser = true;
								}
								else{
									ligne_trouvee = true;
								}
							}
							break;
							
						case 9://controle observationsPrestationCollecte
							if( !(data.isEmpty()) && rivoli_trouve && obsPresColAparser ){
								if(obsPresColAparser){
									ObservationsParsage obs = new ObservationsParsage(data);
									PlageNum plageNum = obs.determinePlageNum();
									if(numAdresse_est_pair){
										if((numAdresse >= plageNum.debutPair || 
												numAdresse <= plageNum.finPair ||
												plageNum.numerosSupplementaires.contains(numAdresse)) &&
												! plageNum.numerosExclus.contains(numAdresse)){
											ligne_trouvee = true;
										}
									}
									else{
										if((numAdresse >= plageNum.debutImpair || 
												numAdresse <= plageNum.finImpair ||
												plageNum.numerosSupplementaires.contains(numAdresse)) &&
												! plageNum.numerosExclus.contains(numAdresse)){
											ligne_trouvee = true;
										}
									}
								}
							}
							break;
							
						case 10://controle bleuJourCollecte
							if( !(data.isEmpty()) && rivoli_trouve && ligne_trouvee){
								if(!data.equals("mixte : voir précisions")){
									String[] splitterBleu1 = data.split(" et ");
									for(String data1 : splitterBleu1){
										String[] splitterBleu2 = data1.split(" - ");
										for(String data2 : splitterBleu2){
											jours.addJourBleu(data2);
											if(bleuESTjaune){
												jours.addJourJaune(data2);
											}
										}
									}
								}
								else{
									bleusMixte = true;
								}
							}
							break;
							
						case 11://controle jauneJourCollecte
							if( !(data.isEmpty()) && rivoli_trouve && ligne_trouvee ){
								String[] splitterJaune1 = data.split(" et ");
								for(String data1 : splitterJaune1){
									String[] splitterJaune2 = data1.split(" - ");
									for(String data2 : splitterJaune2){
										jours.addJourJaune(data2);
									}
								}
							}
							break;
							
						case 12://controle observationsJourCollecte
							if( !(data.isEmpty()) && rivoli_trouve && ligne_trouvee && bleusMixte){
								ObservationsParsage obs = new ObservationsParsage(data);
								PlageJour plageJour = obs.determinePlageJour();
								if(numAdresse_est_pair){
									if(numAdresse >= plageJour.debutPair1 && numAdresse <= plageJour.finPair1){
										for(String jour : plageJour.Jours1){
											jours.addJourBleu(jour);
											if(bleuESTjaune){
												jours.addJourJaune(jour);
											}
										}
									}
									else{
										if(numAdresse >= plageJour.debutPair2 && numAdresse <= plageJour.finPair2){
											for(String jour : plageJour.Jours2){
												jours.addJourBleu(jour);
												if(bleuESTjaune){
													jours.addJourJaune(jour);
												}
											}
										}
									}
								}
								else{
									if(numAdresse >= plageJour.debutImpair1 && numAdresse <= plageJour.finImpair1){
										for(String jour : plageJour.Jours1){
											jours.addJourBleu(jour);
											if(bleuESTjaune){
												jours.addJourJaune(jour);
											}
										}
									}
									else{
										if(numAdresse >= plageJour.debutImpair2 && numAdresse <= plageJour.finImpair2){
											for(String jour : plageJour.Jours2){
												jours.addJourBleu(jour);
												if(bleuESTjaune){
													jours.addJourJaune(jour);
												}
											}
										}
									}
								}
							}
							break;
							
						case 13://quartier
							break;
							
						case 14://observationsQuartier
							break;
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jours;
	}

	
	
	public static void main(String[] args) {
		//exemple pour rentrer les donn�es dans la BD
		Data data4 = new Data("http://data.nantes.fr/api/publication/JOURS_COLLECTE_DECHETS_VDN/JOURS_COLLECTE_DECHETS_VDN_STBL/content/?format=csv");
		ArrayList<Data> dataparsee = data4.parsageFirst("Abélard");
		for(Integer index = 0 ; index<dataparsee.size() ; index++){
			System.out.println("Correspondance n°"+ (index + 1) + " pour Abélard");
			String rivoli = dataparsee.get(index).getRivoli();
			String typeRue = dataparsee.get(index).getTypeRue();
			String libelle = dataparsee.get(index).getLibelle();
			String commune = dataparsee.get(index).getCommune();
			String motDirecteur = dataparsee.get(index).getMotDirecteur();
			String statut = dataparsee.get(index).getStatut();
			String tenant = dataparsee.get(index).getTenant();
			String aboutissant = dataparsee.get(index).getAboutissant();
			String prestationCollecte = dataparsee.get(index).getPrestationCollecte();
			String typeCollecte = dataparsee.get(index).getTypeCollecte();
			String observationsPrestationCollecte = dataparsee.get(index).getObservationsPrestationCollecte();
			String bleuJourCollecte = dataparsee.get(index).getBleuJourCollecte();
			String jauneJourCollecte = dataparsee.get(index).getJauneJourCollecte();
			String observationsJourCollecte = dataparsee.get(index).getObservationsJourCollecte();
			String quartier = dataparsee.get(index).getQuartier();
			String observationsQuartier = dataparsee.get(index).getObservationsQuartier();
			/* affichage des donnees */
			System.out.println("DONE!");
			System.out.println(rivoli + " " + libelle + "\n" + commune + motDirecteur + statut + "...");
			System.out.println(bleuJourCollecte);
			System.out.println(jauneJourCollecte);
		}
		
		data4.resetData();
		//changer le rivoli et le num d'adresse pour tester
		//mais choisir un rivoli qui n'a pas d'observationPrestationCollecte
		//car pas encore géré
		Jours jours = data4.parsageSecond("6128",107);//bien penser à mettre le rivoli sur 4 chiffres
		ArrayList<String> joursBleu = jours.getJoursBleu();
		ArrayList<String> joursJaune = jours.getJoursJaune();
		System.out.println("les jours pour le rivoli 6128 :");
		for(String jour : joursBleu){
			System.out.println(jour);
		}
		for(String jour : joursJaune){
			System.out.println(jour);
		}
	}

}
