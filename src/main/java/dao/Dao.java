package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Seynabou SARR et Melaine BOUE
 */
public class Dao {
	EntityManagerFactory factory;           
    EntityManager manager;
    
	public Dao() {
		
	} 	
	public EntityManager getManager() {
		//on initialise le manager si c'est pas déjà fait
		if(this.manager==null)
		{
			this.factory = Persistence.createEntityManagerFactory("mysql");
			this.manager =  factory.createEntityManager();
		}		
		return manager;
	}
	
	/**
	 * Fermer la connexion
	 */
	public void close() {
		manager.close();
		factory.close();
	}
}

