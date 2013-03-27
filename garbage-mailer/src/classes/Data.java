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
	private ArrayList<String> bleuJourCollecte;
	private ArrayList<String> jauneJourCollecte;
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
		this.bleuJourCollecte = new ArrayList<String>();
		this.jauneJourCollecte = new ArrayList<String>();
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
		this.bleuJourCollecte.add(string);
	}
	
	public void setJauneJourCollecte(String string){
		this.jauneJourCollecte.add(string);
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
	
	public ArrayList<String> getBleuJourCollecte(){
		return this.bleuJourCollecte;
	}
	
	public ArrayList<String> getJauneJourCollecte(){
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

	public ArrayList<Data> parsageAll(){
		ArrayList<Data> dataLine = new ArrayList<Data>();
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
								String[] splitterLibelle = data.split(" ");
								datas.setTypeRue(splitterLibelle[0]);
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
								datas.setQuartier(data);
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
		//exemple pour rentrer les donn�es dans la BD
		Data data4 = new Data("http://data.nantes.fr/api/publication/JOURS_COLLECTE_DECHETS_VDN/JOURS_COLLECTE_DECHETS_VDN_STBL/content/?format=csv");
		for(Integer index = 0 ; index<data4.parsageAll().size() ; index++){
			String rivoli = data4.parsageAll().get(index).getRivoli();
			String typeRue = data4.parsageAll().get(index).getTypeRue();
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
			String quartier = data4.parsageAll().get(index).getQuartier();
			String observationsQuartier = data4.parsageAll().get(index).getObservationsQuartier();
			/* ajout de la ligne de la BD avec les champs r�cup�r� */
			System.out.println("DONE!");
		}
	}

}
