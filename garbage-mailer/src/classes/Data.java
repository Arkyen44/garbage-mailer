package classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Cette classe représente une ligne d'un fichier csv
 * 
 * Elle permet grâce à la méthode ParsageFirst(adresseUtilisateur) 
 * de rechercher une adresse donnée par l'utilisateur
 * et grâce à la méthode ParsageSecond(rivoli, numéro d'adresse) 
 * de rechercher les informations
 * relatives à l'adresse complète de l'utilisateur 
 * Cette adresse complète sera mémorisée par le numéro d'adresse ainsi que le rivoli de celle-ci.
 * 
 * Le rivoli est l'identifiant d'une adresse, mais dans le fichier csv,
 * il y a parfois plusieurs lignes pour un même rivoli, il est donc nécessaire
 * d'avoir le numéro d'adresse de l'utilisateur pour retrouver l'adresse correspondante
 * dans le fichier.
 * 
 * 
 * @author Justine
 *
 */

public class Data implements Serializable{
	private String rivoli;
	/*
	 * le type de rue n'est pas un champs du fichier csv 
	 * mais il peut-être utile de le récupérer
	 * si on veut faire évoluer la plate-forme dans le futur
	 */
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


	/**
	 * Le constructeur de l'objet se fait à partir de l'url du fichier csv
	 * @param urlFichier
	 */
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
	
	/**
	 * Setteur du rivoli 
	 * @param string
	 */
	private void setRivoli(String string){
		this.rivoli = string;
	}
	
	/**
	 * Setteur du type de rue
	 * @param string
	 */
	private void setTypeRue(String string){
		this.typeRue = string;
	}

	/**
	 * Setteur du libelle
	 * @param string
	 */
	private void setLibelle(String string){
		this.libelle = string;
	}

	/**
	 * Setteur de la commune
	 * @param string
	 */
	private void setCommune(String string){
		this.commune = string;
	}

	/**
	 * Setteur du mot directeur
	 * @param string
	 */
	private void setMotDirecteur(String string){
		this.motDirecteur = string;
	}

	/**
	 * Setteur du statut
	 * @param string
	 */
	private void setStatut(String string){
		this.statut = string;
	}

	/**
	 * Setteur du tenant
	 * @param string
	 */
	private void setTenant(String string){
		this.tenant = string;
	}

	/**
	 * Setteur de l'aboutissant
	 * @param string
	 */
	private void setAboutissant(String string){
		this.aboutissant = string;
	}

	/**
	 * Setteur de la prestation
	 * @param string
	 */
	private void setPrestationCollecte(String string){
		this.prestationCollecte = string;
	}

	/**
	 * Setteur du type de collecte
	 * @param string
	 */
	private void setTypeCollecte(String string){
		this.typeCollecte = string;
	}

	/**
	 * Setteur du type de l'observation sur la prestation de la collecte
	 * @param string
	 */
	private void setObservationsPrestationCollecte(String string){
		this.observationsPrestationCollecte = string;
	}

	/**
	 * Setteur des jours de la collecte bleue
	 * @param string
	 */
	private void setBleuJourCollecte(String string){
		this.bleuJourCollecte += " " + string;
	}

	/**
	 * Setteur des jours de la collecte bleue
	 * @param string
	 */
	private void setJauneJourCollecte(String string){
		this.jauneJourCollecte += " " + string;
	}

	/**
	 * Setteur de l'observation sur le jour de la collecte
	 * @param string
	 */
	private void setObservationsJourCollecte(String string){
		this.observationsJourCollecte = string;
	}

	/**
	 * Setteur du quartier
	 * @param string
	 */
	private void setQuartier(String string){
		this.quartier = string;
	}

	/**
	 * Setteur de l'observation sur le quartier
	 * @param string
	 */
	private void setObservationsQuartier(String string){
		this.observationsQuartier = string;
	}

	/**
	 * Getteurs de tout les attributs de la classe Data
	 * @return
	 */
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

	/**
	 * Méthode permettant de réinitialiser un Data
	 * Elle permet de reconstruire le Data sans avoir besoin de 
	 * resaisir l'URL du fichier
	 */
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
		this.setMotDirecteur(motDirecteur); //recherche sur le mot directeur
		ArrayList<Data> dataLine = new ArrayList<Data>(); //liste d'adresses qui sera renvoyée
		try {
			//on se connecte au fichier csv present sur le serveur de l'openData grace a son URL
			URL url = new URL(this.getUrlFichier());
			HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
			httpConnection.connect();
			//on parcourt ce fichier
			InputStreamReader isr = new InputStreamReader(httpConnection.getInputStream(),"UTF-8");
			BufferedReader reader = new BufferedReader(isr);
			
			String line = "";
			//pour chaque ligne du fichier
			while ((line = reader.readLine()) != null) {
				//on splitte chaque champs avec "," qui est le délimiteur du csv
				StringTokenizer splitter = new StringTokenizer(line, ",");
				//on cree un objet pour stocker les informations de la ligne
				Data datas = new Data(this.getUrlFichier());
				
				Boolean trouve = false; //a-t-on trouve une adresse s'approchant de l'adresse recherchee?
				
				for(Integer i=0; splitter.hasMoreTokens() ;i++){ //pour chaque champs
					String data = (String) splitter.nextToken(); //on le recupere dans une chaine de caracteres
					data = data.replace("\"", ""); //on enleve les guillemets au début et à la fin de ce qu'on a récupéré
					switch(i){
					
						case 0://premier champs de la ligne : rivoli
							if(!(data.isEmpty())){
								datas.setRivoli(data); //on enregistre le rivoli
							}
							break;
							
						case 1://second champ : libelle
							if(!(data.isEmpty())){
								String[] splitterLibelle = data.split(" ");
								datas.setTypeRue(splitterLibelle[0]); // on enregistre le type de rue (au cas ou on voudrait changer la recherche par la suite)
								datas.setLibelle(data); //on enregistre le libelle
							}
							break;
							
						case 2://commune
							if(!(data.isEmpty())){
								datas.setCommune(data); //on enregistre la commune
							}
							break;
							
						case 3://controle motDirecteur
							if(!(data.isEmpty())){
								datas.setMotDirecteur(data);
							}
							if(!(this.motDirecteur.equals(""))){ //si on fait la recherche par le mot directeur et que celui-ci n'est pas vide
								String[] splitterMotDirecteur = this.motDirecteur.toUpperCase().split(" "); //on enleve la casse et prend chaque mot de l'adresse
								
								for(String s : splitterMotDirecteur){ //pour chaque mot de l'adresse donnee par l'utilisateur
									//on enleve les eventuelles apostrophes
									if (s.matches(".*'.*"))
										s = s.split("'")[1];
									
									//on fait une comparaison sans accent
									String s1 = StringOperation.sansAccent(s);
									String data1 = StringOperation.sansAccent(data);
									
									//entre le mot directeur de la ligne parcourue et chaque mot de l'adresse utilisateur
									if(data1.toUpperCase().equals(s1)){ //si un mot correspond
										trouve = true; // la ligne correspond à une adresse succeptible d'être celle de l'utilisateur
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
								//on recupere les jours bleus en enlevant les "et" et les "-"
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
								//on recupere les jours bleus en enlevant les "et" et les "-"
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
		return dataLine; //on retourne la liste d'adresses potentielles
	}
	
	/**
	 * Fonction parsageSecond qui servira à rechercher les jours de collecte 
	 * pour les poubelles bleus et jaunes
	 * Elle renverra un objet Jours comprenant deux attributs de type ArrayList<Integer>
	 * contenant respectivement les jours de collecte pour les poubelles et
	 * les jours de collectes pour les poubelles jaunes
	 * en fonction du rivoli de l'adresse de l'utilisateur ainsi que de son numero d'adresse
	 */
	public Jours parsageSecond(String rivoli,Integer numAdresse){
		this.setRivoli(rivoli);
		//renseignements sur le numAdresse
		Boolean numAdresse_est_pair = false; //est-il pair?
		if(numAdresse%2 == 0){
			numAdresse_est_pair = true;
		}
		
		Jours jours = new Jours(); //objet qui sera retourné
		
		try {
			//on se connecte au fichier csv present sur le serveur de l'openData grace a son URL
			URL url = new URL(this.getUrlFichier());
			HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
			httpConnection.connect();
			//on parcourt ce fichier
			InputStreamReader isr = new InputStreamReader(httpConnection.getInputStream(),"UTF-8");
			BufferedReader reader = new BufferedReader(isr);
			
			String line = "";
			//pour chaque ligne
			Boolean rivoli_trouve = false; //a-t-on trouvé le rivoli?
			Boolean ligne_trouvee = false; //a-t-on trouvé l'adresse?
			while ((line = reader.readLine()) != null) {
				if((!rivoli_trouve) || (!ligne_trouvee)){// si on a n'y trouvé le rivoli , ni la bonne ligne
					StringTokenizer splitter = new StringTokenizer(line, ",");//on splitte la ligne avec le délimiteur du csv
					Boolean bleusMixte = false; //les jours bleus dépendent-ils du numéro d'adresse?
					Boolean bleuESTjaune = false; //les poubelles bleues sont-elles ramassées en même temps que les poubelles jaunes?
					Boolean obsPresColAparser = false; //faut-il parser l'observation de la collecte?
						
					for(Integer i=0; splitter.hasMoreTokens() ;i++){
						String data = (String) splitter.nextToken();
						data = data.replace("\"", ""); //on enlève les guillemets au début et à la fin de ce qu'on a récupéré dans le fichier
						switch(i){
						
							case 0://controle rivoli
								//si ce qu'on a récupéré n'est pas vide et qu'il s'agit bien du rivoli recherché
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
									//si la prestation est trisac ou extension trisac ou en centre-ville
									if(data.replaceAll("'","").equals("TRISAC") ||
											data.equals("Centre-ville en C3") ||
											data.equals("extension trisac 2013")){
										bleuESTjaune = true; // alors les poubelles jaunes sont récupérées le jour des poubelles bleues
									}
								}
								break;
								
							case 8://controle typeCollecte
								if( !(data.isEmpty()) && rivoli_trouve){
									if(data.equals("pluriel")){ //si le type de la collecte est pluriel
										obsPresColAparser = true; //il faut parser les observations de la collecte pour savoir si on est dans la bonne ligne
									}
									else{
										ligne_trouvee = true;
									}
								}
								break;
								
							case 9://controle observationsPrestationCollecte
								if( !(data.isEmpty()) && rivoli_trouve && obsPresColAparser){ // si le type de la collecte est pluriel
									//on créé un nouvel objet ObservationsParsage qui permet de parser 
									//les différentes observations du fichier csv écrit en langage naturel
									ObservationsParsage obs = new ObservationsParsage(data);
									//plageNum est la plage de numéros d'adresse comprise dans la ligne du fichier csv
									PlageNum plageNum = obs.determinePlageNum();
									//on regarde si le numéro d'adresse de l'utilisateur se trouve dans cette plage
									if(numAdresse_est_pair){
										if( ( (numAdresse >= plageNum.debutPair) && 
												(numAdresse <= plageNum.finPair) &&
												(!plageNum.numerosExclus.contains(numAdresse)) ) || 
												( plageNum.numerosSupplementaires.contains(numAdresse) ) ){
											ligne_trouvee = true;
										}
									}
									else{
										if( ( (numAdresse >= plageNum.debutImpair) && 
												(numAdresse <= plageNum.finImpair) &&
												(!plageNum.numerosExclus.contains(numAdresse)) ) ||
												( plageNum.numerosSupplementaires.contains(numAdresse) ) ){
											ligne_trouvee = true;
										}
									}
								}
								break;
								
							case 10://controle bleuJourCollecte
								if( !(data.isEmpty()) && rivoli_trouve && ligne_trouvee){
									// si le champs des jours de collecte n'est pas mixte
									if(!data.equals("mixte : voir précisions")){
										// on splitte ce champs avec "et" et "-" pour récupérer les jours
										String[] splitterBleu1 = data.split(" et ");
										for(String data1 : splitterBleu1){
											String[] splitterBleu2 = data1.split(" - ");
											for(String data2 : splitterBleu2){
												jours.addJourBleu(data2);
												if(bleuESTjaune){ //si la distribution jaune se fait en même temps que la distribution bleue
													jours.addJourJaune(data2); // on ajoute les jours bleues aux jours jaunes
												}
											}
										}
									}
									else{
										//sinon bleu est mixte 
										//et il faudra faire une recherche 
										//dans l'observation du jour de collecte
										bleusMixte = true;
									}
								}
								break;
								
							case 11://controle jauneJourCollecte
								if( !(data.isEmpty()) && rivoli_trouve && ligne_trouvee ){
									//on splitte avec "et" et "-" pour récupérer les jours jaunes
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
								if( !(data.isEmpty()) && rivoli_trouve && ligne_trouvee && bleusMixte){ //si les jours bleus sont mixtes
									//on créé un nouvel objet ObservationsParsage qui permet de parser 
									//les différentes observations du fichier csv écrit en langage naturel
									ObservationsParsage obs = new ObservationsParsage(data);
									//plageJour est un objet permettant d'associer un ou plusieurs jours de collecte à un numéro d'adresse
									PlageJour plageJour = obs.determinePlageJour();
									//on regarde dans quel plage se trouve le numéro d'adresse de l'utilisateur
									//puis on ajoute les jours bleus adéquats
									//ainsi que les jours jaunes s'ils doivent être les mêmes
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
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jours;
	}

	
	/**
	 * Test de l'objet Data
	 * @param args
	 */
	public static void main(String[] args) {
		Data data4 = new Data("http://data.nantes.fr/api/publication/JOURS_COLLECTE_DECHETS_VDN/JOURS_COLLECTE_DECHETS_VDN_STBL/content/?format=csv");
		ArrayList<Data> dataparsee = data4.parsageFirst("abélard");
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
		Jours jours = data4.parsageSecond("0592",37);//bien penser à mettre le rivoli sur 4 chiffres
		ArrayList<String> joursBleu = jours.getJoursBleu();
		ArrayList<String> joursJaune = jours.getJoursJaune();
		System.out.println("les jours pour le rivoli 0592 :");
		System.out.println("Bleu :");
		for(String jour : joursBleu){
			System.out.println(jour);
		}
		System.out.println("Jaunes :");
		for(String jour : joursJaune){
			System.out.println(jour);
		}
	}

}
