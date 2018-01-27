package dao;

import java.util.List;

import javax.persistence.*;
import javax.persistence.criteria.*;

import domain.*;

public class DaoHome {
	
	Dao managerObject;
	EntityManager manager;
    
	public DaoHome() {
		managerObject = new Dao();
		manager = managerObject.getManager();
	} 
      
	
    
	
	public void close() {
		managerObject.close();
		manager.close();
	}
	
    public void listHome() {
        List<Home> resultList = manager.createQuery("Select a From Person a", Home.class).getResultList();
        
        for (Home home : resultList) {
            System.out.println(home.toString());
        }
    }
    
   public void listHomes() {
	CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
	CriteriaQuery<Home> query = criteriaBuilder.createQuery(Home.class);
	Root<Devices> from = query.from(Devices.class);
	/* for(Person p: from) {
		 System.out.println(p.toString());
	 }
	//query.select(from.get("a"))
	     .where(from.get("a").in(1, 2, 3, 4));*/
   }
   
   
   public void modify(Home home)
   {
	   manager.merge(home);
   }
}

