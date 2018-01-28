package dao;

import java.util.List;

import javax.persistence.*;
import javax.persistence.criteria.*;

import domain.*;

public class DaoDevices {
	
	Dao managerObject;
	EntityManager manager;
    
	public DaoDevices() {
		managerObject = new Dao();
		manager = managerObject.getManager();
	} 
      
	
    
	
	public void close() {
		managerObject.close();
		manager.close();
	}
	
    public void listDevice() {
        List<Devices> resultList = manager.createQuery("Select a From Person a", Devices.class).getResultList();
        
        for (Devices device : resultList) {
            System.out.println(device.toString());
        }
    }
    
   public void listDevices() {
	CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
	CriteriaQuery<Devices> query = criteriaBuilder.createQuery(Devices.class);
	Root<Devices> from = query.from(Devices.class);
	/* for(Person p: from) {
		 System.out.println(p.toString());
	 }
	//query.select(from.get("a"))
	     .where(from.get("a").in(1, 2, 3, 4));*/
   }
   
   
   public void update(Devices device)
   {
	   manager.merge(device);
   }
   
   public void delete(Devices device)
   {
	   manager.remove(device);
   }
}

