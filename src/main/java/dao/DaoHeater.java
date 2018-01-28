package dao;

import java.util.List;

import javax.persistence.*;
import javax.persistence.criteria.*;

import domain.*;

public class DaoHeater {
	
	Dao managerObject;
	EntityManager manager;
    
	public DaoHeater() {
		managerObject = new Dao();
		manager = managerObject.getManager();
	} 
      
	
    
	
	public void close() {
		managerObject.close();
		manager.close();
	}
	
    public void listHeater() {
        List<Heater> resultList = manager.createQuery("Select a From Person a", Heater.class).getResultList();
        
        for (Heater heater : resultList) {
            System.out.println(heater.toString());
        }
    }
    
   public void listHeaters() {
	CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
	CriteriaQuery<Heater> query = criteriaBuilder.createQuery(Heater.class);
	Root<Heater> from = query.from(Heater.class);
	/* for(Person p: from) {
		 System.out.println(p.toString());
	 }
	//query.select(from.get("a"))
	     .where(from.get("a").in(1, 2, 3, 4));*/
   }
   
   
   public void update(Heater heater)
   {
	   manager.merge(heater);
   }



	
	public void delete(Heater heater)
	{
	   manager.remove(heater);
	}
}

