package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Seynabou SARR et Melaine BOUE
 */
public class Dao {
/**
 * g�re la connexion persist.
 */
 private EntityManagerFactory factory;
 /**
  * le manager.
  */
 private EntityManager manager;
 /**
  * Constructor.
  */
  public Dao() { }
/**
 * getteur de la connexion.
 * @return factory
*/
  public final EntityManagerFactory getFactory() {
  return factory;
  }
/**
 * modifier la connexion.
 * @param factory
*/
  public final void setFactory(EntityManagerFactory factory) {
  this.factory = factory;
  }
/**
 * modifier la connexion.
 * @param manager
*/
  public final void setManager(EntityManager manager) {
  this.manager = manager;
  }
/**
 * getteur de la connexion.
  * @return manager
*/
  public final EntityManager getManager() {
		//on initialise le manager si c'est pas déjà fait.
  if(this.manager==null){
	  this.factory = Persistence.createEntityManagerFactory("mysql");
	  this.manager =  factory.createEntityManager();
	  }
  return manager;
  }
/**
* Fermer la connexion.
*/
  public void close() {
	 manager.close();
	 factory.close();
	 }
}

