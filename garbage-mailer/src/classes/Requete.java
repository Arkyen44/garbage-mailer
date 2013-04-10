package classes;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;

import beans.UserBean;

/**
 * Ensemble des requêtes 
 * @author Nico
 *
 */
public final class Requete {
	
	/**
	 * Retourne une liste de tuple contenant le nom de l'utilisateur.
	 * Si l'utilisateur n'est pas présent, la liste renvoyée est nulle.
	 * @param name nom de l'utilisateur
	 * @return une liste de tuple contenant le nom de l'utilisateur
	 */
	public static List<UserBean> getUser(String name){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String query =
      			"SELECT FROM " + UserBean.class.getName() +
			 	" WHERE name == '"+name+"'";
		List<UserBean> liste = (List<UserBean>) pm.newQuery(query).execute();
		pm.close();
		if (liste.size() == 0)
			return null; 
		else
			return liste;
	}
	
	/**
	 * Supprime une adresse en base de donnée
	 * @param rivo identifiant de l'adresse
	 * @param name nom de l'adresse
	 */
	public static void delAddress(String rivo, String name){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String query =
      			"SELECT FROM " + UserBean.class.getName() +
			 	" WHERE name == '"+name+"' && rivolli == '"+rivo+"'";
		
		List<UserBean> liste = (List<UserBean>) pm.newQuery(query).execute();
		if (liste != null && liste.size()>0)
				pm.deletePersistent(liste.get(0));
		pm.close();
	}
	
	/**
	 * Renvoie vrai si le tuple cherché existe déjà en base de données,
	 * faux sinon.
	 * @param userName nom de l'utilisateur
	 * @param rivolli identifiant de la rue
	 * @param num numéro de la maison dans la rue
	 * @return boolean
	 */
	public static boolean exist(String userName, String rivolli, String num){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String query =
      			"SELECT FROM " + UserBean.class.getName() +
			 	" WHERE name == '"+userName+"' && rivolli == '"+rivolli+"' && numero == '"+ num +"'";
		
		List<UserBean> liste = (List<UserBean>) pm.newQuery(query).execute();
		pm.close();
		if (liste != null){
			if (liste.size()>0)
					return true;
			else return false;
		}else return false;
				
	}
	
	public static List<UserBean> destinatairesBleu(String jour, String mail){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String query =
      			"SELECT FROM " + UserBean.class.getName() +
      			" WHERE name == '"+mail+"'";
		List<UserBean> liste = (List<UserBean>) pm.newQuery(query).execute();
		List<UserBean> listeBleue = new ArrayList<UserBean>();
		
		for (UserBean ub : liste){
			if (ub.getBleu().contains(jour)){
				listeBleue.add(ub);
			}
		}
		pm.close();
		if (listeBleue != null){
			if (listeBleue.size()>0)
					return listeBleue;
			else return null;
		}else return null;
	}
	
	public static List<UserBean> destinatairesJaune(String jour, String mail){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String query =
      			"SELECT FROM " + UserBean.class.getName() +
      			" WHERE name == '"+mail+"'";
		List<UserBean> liste = (List<UserBean>) pm.newQuery(query).execute();
		List<UserBean> listeJaune = new ArrayList<UserBean>();
		
		for (UserBean ub : liste){
			if (ub.getJaune().contains(jour)){
				listeJaune.add(ub);
			}
		}
		pm.close();
		if (listeJaune != null){
			if (listeJaune.size()>0)
					return listeJaune;
			else return null;
		}else return null;
	}
}
