package classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Data {
	private String rivoli;
	private String libelle;
	private String commune;
	private String motDirecteur;
	private String statut;
	private String tenant;
	private String aboutissant;
	private String prestationCollecte;
	private String typeCollecte;
	private String observationsPrestationCollecte;
	private ArrayList<String> bleuJourCollecte;
	private ArrayList<String> jauneJourCollecte;
	private String observationsJourCollecte;
	private ArrayList<String> quartier;
	private String observationsQuartier;
	
	private String urlFichier;

	
	public Data(String urlFichier){
		this.rivoli = "";
		this.libelle = "";
		this.commune = "";
		this.motDirecteur = "";
		this.statut = "";
		this.tenant = "";
		this.aboutissant = "";
		this.prestationCollecte = "";
		this.typeCollecte = "";
		this.observationsPrestationCollecte = "";
		this.bleuJourCollecte = new ArrayList<String>();
		this.jauneJourCollecte = new ArrayList<String>();
		this.observationsJourCollecte = "";
		this.quartier = new ArrayList<String>();
		this.observationsQuartier = "";
		
		this.urlFichier = urlFichier;
	}
	
	public void setRivoli(String string){
		this.rivoli = string;
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
		this.bleuJourCollecte.add(string);
	}
	
	public void setJauneJourCollecte(String string){
		this.jauneJourCollecte.add(string);
	}
	
	public void setObservationsJourCollecte(String string){
		this.observationsJourCollecte = string;
	}
	
	public void setQuartier(String string){
		this.quartier.add(string);
	}
	
	public void setObservationsQuartier(String string){
		this.observationsQuartier = string;
	}

	public String getRivoli(){
		return this.rivoli;
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
	
	public ArrayList<String> getBleuJourCollecte(){
		return this.bleuJourCollecte;
	}
	
	public ArrayList<String> getJauneJourCollecte(){
		return this.jauneJourCollecte;
	}
	
	public String getObservationsJourCollecte(){
		return this.observationsJourCollecte;
	}
	
	public ArrayList<String> getQuartier(){
		return this.quartier;
	}
	
	public String getObservationsQuartier(){
		return this.observationsQuartier;
	}
	
	public String getUrlFichier(){
		return this.urlFichier;
	}
	
	
	public ArrayList<Data> parsage(){
		ArrayList<Data> dataLine = new ArrayList<Data>();
		try {
			URL url = new URL(this.getUrlFichier());
			HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
			httpConnection.connect();
			InputStreamReader isr = new InputStreamReader(httpConnection.getInputStream());
			BufferedReader reader = new BufferedReader(isr);
			
			
			String line = "";
			//à chaque ligne
			while ((line = reader.readLine()) != null) {
				StringTokenizer splitter = new StringTokenizer(line, ",");
				String ajouter = "false";
				Data datas = new Data(this.getUrlFichier());
				
				for(Integer i=0; splitter.hasMoreTokens();i++){
					String data = (String) splitter.nextToken();
					data = data.replace("\"", "");
					switch(i){
					
						case 0://controle rivoli
							if(!(data.isEmpty())){
								datas.setRivoli(data);
							}
							if(!(this.rivoli.equals("")) && data.equals(this.rivoli)){
								ajouter = "true";
							}
							break;
							
						case 1://controle libelle
							if(!(data.isEmpty())){
								datas.setLibelle(data);
							}
							
							if(!(this.libelle.equals("")) && data.equals(this.libelle)){
								ajouter = "true";
							}
							break;
							
						case 2://controle commune
							if(!(data.isEmpty())){
								datas.setCommune(data);
							}
							
							if(!(this.commune.equals("")) && data.equals(this.commune)){
								ajouter = "true";
							}
							break;
							
						case 3://controle motDirecteur
							if(!(data.isEmpty())){
								datas.setMotDirecteur(data);
							}	
							if(!(this.motDirecteur.equals("")) && data.equals(this.motDirecteur)){
								ajouter = "true";
							}
							break;
							
						case 4://controle statut
							if(!(data.isEmpty())){
								datas.setStatut(data);
							}
							if(!(this.statut.equals("")) && data.equals(this.statut)){
								ajouter = "true";
							}
							break;
							
						case 5://controle tenant
							if(!(data.isEmpty())){
								datas.setTenant(data);
							}
							if(!(this.tenant.equals("")) && data.equals(this.tenant)){
								ajouter = "true";
							}
							break;
							
						case 6://controle aboutissant
							if(!(data.isEmpty())){
								datas.setAboutissant(data);
							}
							if(!(this.aboutissant.equals("")) && data.equals(this.aboutissant)){
								ajouter = "true";
							}
							break;
							
						case 7://controle prestationCollecte
							if(!(data.isEmpty())){
								datas.setPrestationCollecte(data);
							}
							if(!(this.prestationCollecte.equals("")) && data.equals(this.prestationCollecte)){
								ajouter = "true";
							}
							break;
							
						case 8://controle typeCollecte
							if(!(data.isEmpty())){
								datas.setTypeCollecte(data);
							}
							if(!(this.typeCollecte.equals("")) && data.equals(this.typeCollecte)){
								ajouter = "true";
							}
							break;
							
						case 9://controle observationsPrestationCollecte
							if(!(data.isEmpty())){
								datas.setObservationsPrestationCollecte(data);
							}
							if(!(this.observationsPrestationCollecte.equals("")) && data.equals(this.observationsPrestationCollecte)){
								ajouter = "true";
							}
							break;
							
						case 10://controle bleuJourCollecte
							if(!(data.isEmpty())){
								String[] splitterBleu1 = data.split(" et ");
								for(String data1 : splitterBleu1){
									String[] splitterBleu2 = data1.split(" - ");
									for(String data2 : splitterBleu2){
										datas.setBleuJourCollecte(data2);
										for(Integer j = 0 ; j<this.bleuJourCollecte.size() ; j++){
											if(data2.equals(this.bleuJourCollecte.get(j))){
												ajouter = "true";
											}
										}
									}
								}
							}
							break;
							
						case 11://controle jauneJourCollecte
							if(!(data.isEmpty())){
								String[] splitterJaune1 = data.split(" et ");
								for(String data1 : splitterJaune1){
									String[] splitterJaune2 = data1.split(" - ");
									for(String data2 : splitterJaune2){
										datas.setJauneJourCollecte(data2);
										for(Integer j = 0 ; j<this.jauneJourCollecte.size() ; j++){
											if(data2.equals(this.jauneJourCollecte.get(j))){
												ajouter = "true";
											}
										}
									}
								}
							}
							break;
							
						case 12://controle observationsJourCollecte
							if(!(data.isEmpty())){
								datas.setObservationsJourCollecte(data);
							}
							if(!(this.observationsJourCollecte.equals("")) && data.equals(this.observationsJourCollecte)){
								ajouter = "true";
							}
							break;
							
						case 13://controle quartier
							if(!(data.isEmpty())){
								String[] splitterQuartier1 = data.split(" - ");
								for(String data1 : splitterQuartier1){
									datas.setQuartier(data1);
									for(Integer j = 0 ; j<this.quartier.size() ; j++){
										if(data1.equals(this.quartier.get(j))){
											ajouter = "true";
										}
									}
								}
							}
							break;
							
						case 14://controle observationsQuartier
							if(!(data.isEmpty())){
								datas.setObservationsQuartier(data);
							}
							if(!(this.observationsQuartier.equals("")) && data.equals(this.observationsQuartier)){
								ajouter = "true";
							}
							break;
					}
				}
				
				if(ajouter == "true"){
					dataLine.add(datas);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataLine;
	}

	public ArrayList<Data> parsageAll(){
		ArrayList<Data> dataLine = new ArrayList<Data>();
		try {
			URL url = new URL(this.getUrlFichier());
			HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
			httpConnection.connect();
			InputStreamReader isr = new InputStreamReader(httpConnection.getInputStream());
			BufferedReader reader = new BufferedReader(isr);
			
			
			String line = "";
			//à chaque ligne
			while ((line = reader.readLine()) != null) {
				StringTokenizer splitter = new StringTokenizer(line, ",");
				Data datas = new Data(this.getUrlFichier());
				
				for(Integer i=0; splitter.hasMoreTokens();i++){
					String data = (String) splitter.nextToken();
					data = data.replace("\"", "");
					switch(i){
					
						case 0://controle rivoli
							if(!(data.isEmpty())){
								datas.setRivoli(data);
							}
							break;
							
						case 1://controle libelle
							if(!(data.isEmpty())){
								datas.setLibelle(data);
							}
							break;
							
						case 2://controle commune
							if(!(data.isEmpty())){
								datas.setCommune(data);
							}
							break;
							
						case 3://controle motDirecteur
							if(!(data.isEmpty())){
								datas.setMotDirecteur(data);
							}
							break;
							
						case 4://controle statut
							if(!(data.isEmpty())){
								datas.setStatut(data);
							}
							break;
							
						case 5://controle tenant
							if(!(data.isEmpty())){
								datas.setTenant(data);
							}
							break;
							
						case 6://controle aboutissant
							if(!(data.isEmpty())){
								datas.setAboutissant(data);
							}
							break;
							
						case 7://controle prestationCollecte
							if(!(data.isEmpty())){
								datas.setPrestationCollecte(data);
							}
							break;
							
						case 8://controle typeCollecte
							if(!(data.isEmpty())){
								datas.setTypeCollecte(data);
							}
							break;
							
						case 9://controle observationsPrestationCollecte
							if(!(data.isEmpty())){
								datas.setObservationsPrestationCollecte(data);
							}
							break;
							
						case 10://controle bleuJourCollecte
							if(!(data.isEmpty())){
								String[] splitterBleu1 = data.split(" et ");
								for(String data1 : splitterBleu1){
									String[] splitterBleu2 = data1.split(" - ");
									for(String data2 : splitterBleu2){
										datas.setBleuJourCollecte(data2);
									}
								}
							}
							break;
							
						case 11://controle jauneJourCollecte
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
							
						case 12://controle observationsJourCollecte
							if(!(data.isEmpty())){
								datas.setObservationsJourCollecte(data);
							}
							break;
							
						case 13://controle quartier
							if(!(data.isEmpty())){
								String[] splitterQuartier1 = data.split(" - ");
								for(String data1 : splitterQuartier1){
									datas.setQuartier(data1);
								}
							}
							break;
							
						case 14://controle observationsQuartier
							if(!(data.isEmpty())){
								datas.setObservationsQuartier(data);
							}
							break;
					}
				}
				dataLine.add(datas);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataLine;
	}
	
	

	
	
	public static void main(String[] args) {
		// exemple d'utilisation si pas rentrée dans le BD
		Data data1 = new Data("http://data.nantes.fr/api/publication/JOURS_COLLECTE_DECHETS_VDN/JOURS_COLLECTE_DECHETS_VDN_STBL/content/?format=csv");
		Data data2 = new Data("http://data.nantes.fr/api/publication/JOURS_COLLECTE_DECHETS_VDN/JOURS_COLLECTE_DECHETS_VDN_STBL/content/?format=csv");
		Data data3 = new Data("http://data.nantes.fr/api/publication/JOURS_COLLECTE_DECHETS_VDN/JOURS_COLLECTE_DECHETS_VDN_STBL/content/?format=csv");
		
		data2.setLibelle("Boulevard Albert Einstein");
		System.out.println("Quartier de Boulevard Albert Einstein : " + data2.parsage().get(0).getQuartier().get(0));
		
		data1.setLibelle("Passage Alvar Aalto");
		System.out.println("Les quartiers du Passage Alvar Aalto :");
		for(Integer i = 0; i<data1.parsage().size();i++){
			for(Integer j = 0 ; j<data1.parsage().get(i).getQuartier().size() ; j++){
				System.out.print("Quartier : " + data1.parsage().get(i).getQuartier().get(j)+"\n");
			}
		}
		
		data3.setBleuJourCollecte("vendredi");
		System.out.println("Les quartiers où les poubelles bleues passent le vendredi");
		for(Integer i =0 ; i<data3.parsage().size() ; i++){
			for(Integer j = 0 ; j<data3.parsage().get(i).getQuartier().size() ; j++){
				System.out.println("Qurtier : " + data3.parsage().get(i).getQuartier().get(j) + "\n");
			}
		}
		
		//exemple pour rentrer les données dans la BD
		Data data4 = new Data("http://data.nantes.fr/api/publication/JOURS_COLLECTE_DECHETS_VDN/JOURS_COLLECTE_DECHETS_VDN_STBL/content/?format=csv");
		for(Integer index = 0 ; index<data4.parsageAll().size() ; index++){
			String rivoli = data4.parsageAll().get(index).getRivoli();
			String libelle = data4.parsageAll().get(index).getLibelle();
			String commune = data4.parsageAll().get(index).getCommune();
			String motDirecteur = data4.parsageAll().get(index).getMotDirecteur();
			String statut = data4.parsageAll().get(index).getStatut();
			String tenant = data4.parsageAll().get(index).getTenant();
			String aboutissant = data4.parsageAll().get(index).getAboutissant();
			String prestationCollecte = data4.parsageAll().get(index).getPrestationCollecte();
			String typeCollecte = data4.parsageAll().get(index).getTypeCollecte();
			String observationsPrestationCollecte = data4.parsageAll().get(index).getObservationsPrestationCollecte();
			ArrayList<String> bleuJourCollecte = data4.parsageAll().get(index).getBleuJourCollecte();
			ArrayList<String> jauneJourCollecte = data4.parsageAll().get(index).getJauneJourCollecte();
			String observationsJourCollecte = data4.parsageAll().get(index).getObservationsJourCollecte();
			ArrayList<String> quartier = data4.parsageAll().get(index).getQuartier();
			String observationsQuartier = data4.parsageAll().get(index).getObservationsQuartier();
			/* ajout de la ligne de la BD avec les champs récupéré */
			System.out.println("DONE!");
		}
	}

}
