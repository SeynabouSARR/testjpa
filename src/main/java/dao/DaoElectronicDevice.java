package dao;

import java.util.List;

import javax.persistence.*;
import javax.persistence.criteria.*;

import domain.*;

public class DaoElectronicDevice {	
	Dao managerObject;
	EntityManager manager;
	EntityTransaction transaction;
    
	public DaoElectronicDevice() {
		managerObject = new Dao();
		manager = managerObject.getManager();
		transaction = manager.getTransaction();
	} 
	
	public void close() {
		managerObject.fermer();
		manager.close();
	}
		
/************************CRUD*************************/

	/**
	 * Cr�e une ElectronicDevice dans la base de donn�es
	 * @param d : l'element � inserer dans la base de donn�es
	 */
	public void createElectronicDevice(ElectronicDevice d){
		transaction.begin();
		manager.persist(d);
		transaction.commit();
	}
	
	/**
	 * Afficher les donn�es relatives � toutes les ElectronicDevices
	 */
    public void showElectronicDevices() {
        List<ElectronicDevice> resultList = manager.createQuery("Select a From ElectronicDevice a", ElectronicDevice.class).getResultList();
        
        for (ElectronicDevice ElectronicDevice : resultList) {
            System.out.println(ElectronicDevice.toString());
        }
    }
    
    /**
     * Reccup�re la liste des ElectronicDevices de la base de donn�es
     * @return la liste des ElectronicDevices
     */
   public List<ElectronicDevice> getElectronicDevices() {

	   CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<ElectronicDevice> criteriaQuery = criteriaBuilder.createQuery(ElectronicDevice.class);
		Root<ElectronicDevice> from = criteriaQuery.from(ElectronicDevice.class);
		criteriaQuery.select(from);
		TypedQuery<ElectronicDevice> query = manager.createQuery(criteriaQuery);
		List<ElectronicDevice> electronicDevices = query.getResultList();
		
		return electronicDevices;
   }
   
   
   /**
    * Recherche une ElectronicDevice ayant pour identifiant id
    * @param id : identification de la ElectronicDevice � reccuperer
    * @return la ElectronicDevice ayant pour identifiant id
    */
   public ElectronicDevice getElectronicDevice(int id)
   {
	  Long identifiant = new Long(id);
	  return manager.find(ElectronicDevice.class, identifiant);
	   
   }
   
   /**
    * Mis � jour la ElectronicDevice dans la base de donn�es
    * @param electronicDevice : nouvelle donn�es
    */
   public void update(ElectronicDevice electronicDevice)
   {
	   manager.merge(electronicDevice);
   }



   /**
    * Supprime le ElectronicDevice electronicDevice
    * @param electronicDevice : electronicDevice � supprimer
    */
	public void delete(ElectronicDevice electronicDevice)
	{
	   manager.remove(electronicDevice);
	}
}

