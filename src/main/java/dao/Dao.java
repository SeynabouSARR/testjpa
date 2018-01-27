package dao;

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
		
	} 
      
	
	public EntityManager getManager() {
		
		if(this.manager==null)
		{
			this.factory = Persistence.createEntityManagerFactory("mysql");
			this.manager =  factory.createEntityManager();
		}
		
		return manager;
	}
	
	
	public void close() {
		manager.close();
		factory.close();
	}
}

