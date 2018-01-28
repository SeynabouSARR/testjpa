package dao;

import java.util.List;

import javax.persistence.*;
import javax.persistence.criteria.*;

import domain.*;

public class DaoHeater {
	
	Dao managerObject;
	EntityManager manager;
	EntityTransaction transaction;
    
	public DaoHeater() {
		managerObject = new Dao();
		manager = managerObject.getManager();
		transaction = manager.getTransaction();
	} 
      
	
    
	
	public void close() {
		managerObject.close();
		manager.close();
	}
	
	
	
	/************************CRUD*************************/
	/************************CRUD*************************/
	/************************CRUD*************************/
	
	/**
	 * Cr�e une Heater dans la base de donn�es
	 */
	public void createHeater(Heater h){
		transaction.begin();
		manager.persist(h);
		transaction.commit();
	}
	
	/**
	 * Afficher les donn�es relatives � toutes les Heaters
	 */
    public void showHeaters() {
        List<Heater> resultList = manager.createQuery("Select a From Heater a", Heater.class).getResultList();
        
        for (Heater heater : resultList) {
            System.out.println(heater.toString());
        }
    }
    
    /**
     * Reccup�re la liste des Heaters de la base de donn�es
     * @return la liste des Heaters
     */
   public List<Heater> getHeaters() {

	   CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<Heater> criteriaQuery = criteriaBuilder.createQuery(Heater.class);
		Root<Heater> from = criteriaQuery.from(Heater.class);
		criteriaQuery.select(from);
		TypedQuery<Heater> query = manager.createQuery(criteriaQuery);
		List<Heater> heaters = query.getResultList();
		
		return heaters;
   }
   
   
   /**
    * Recherche une Heater ayant pour identifiant id
    * @param id : identification de la Heater � reccuperer
    * @return la Heater ayant pour identifiant id
    */
   public Heater getHeater(int id)
   {
	  Long identifiant = new Long(id);
	  return manager.find(Heater.class, identifiant);
	   
   }
   
   /**
    * Mis � jour la Heater dans la base de donn�es
    * @param Heater : nouvelle donn�es
    */
   public void update(Heater heater)
   {
	   manager.merge(heater);
   }



   /**
    * Supprime le Heater Heater
    * @param Heater : Heater � supprimer
    */
	public void delete(Heater heater)
	{
	   manager.remove(heater);
	}
}

