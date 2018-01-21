package domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class Dao {
	EntityManagerFactory factory ;           
    EntityManager manager;
    
	public Dao() {
		this.factory = Persistence.createEntityManagerFactory("mysql");
		this.manager =  factory.createEntityManager();
	} 
      
	public void createPerson(Person p){
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(p);
		transaction.commit();
	}
    
	public void createHeater(Heater heater){
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(heater);
		transaction.commit();
	}
	public void createElectronicDevice(ElectronicDevice electronicDevice){
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(electronicDevice);
		transaction.commit();
	}
	public void createHome(Home home){
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(home);
		transaction.commit();
	}
	public void close() {
		manager.close();
		factory.close();
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

