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
	public void DeletePerson(Person id) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.remove(id);
		transaction.commit();
		
	}
    public void listPerson() {
        List<Person> resultList = manager.createQuery("Select a From Person a", Person.class).getResultList();
        System.out.println("num of persons:" + resultList.size());
        for (Person next : resultList) {
            System.out.println("next person: " + next);
        }
    }
    
   public void listPersons() {
	CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
	CriteriaQuery<Person> query = criteriaBuilder.createQuery(Person.class);
	Root<Person> from = query.from(Person.class);
	/* for(Person p: from) {
		 System.out.println(p.toString());
	 }
	//query.select(from.get("a"))
	     .where(from.get("a").in(1, 2, 3, 4));*/
   }
}

