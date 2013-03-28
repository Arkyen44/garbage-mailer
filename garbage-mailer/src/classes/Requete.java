package classes;

import java.util.List;

import javax.jdo.PersistenceManager;

import beans.UserBean;

public final class Requete {
	
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
	
	public static void delAddress(String nomRue, String name){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		nomRue = nomRue.replace("'", "\'\'");
		String query =
      			"SELECT FROM " + UserBean.class.getName() +
			 	" WHERE name == '"+name+"' && address == '"+nomRue+"'";
		
		List<UserBean> liste = (List<UserBean>) pm.newQuery(query).execute();
		if (liste != null)
				pm.deletePersistent(liste.get(0));
		pm.close();
	}
	
	
}
