package domain;

import java.util.ArrayList;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dao.*;

public class Main {

	public static void main(String[] args) {
		
	    DaoPerson personManager = new DaoPerson();
	    DaoDevice deviceManager = new DaoDevice();
	    DaoHome homeManager = new DaoHome();
	    DaoHeater heaterManager = new DaoHeater();
	    DaoElectronicDevice electronicDeviceManager = new DaoElectronicDevice();
	    
	    
		try {
	        Collection <Heater> heaters=  new ArrayList();
			Heater heater= new Heater();
			heaters.add(heater);
			Collection <Home> homes= new ArrayList();
			Home home = new Home();
			Collection<ElectronicDevice> electronicDevices = new ArrayList();
			ElectronicDevice ed= new ElectronicDevice();
			electronicDevices.add(ed);
			Collection<Person> persons = new ArrayList();
			Person p = new Person("SARR", "Seynabou","13 A rue du Bois Perrin",persons, homes,electronicDevices);
			Collection<Person> pers= new ArrayList();
			Person person= new Person("BOUE", "MELAINE","BOIS PERRIN", null, null, null);
			persons.add(person);
			pers.add(p);
			pers.add(person);
			
			
			heaterManager.createHeater(heater);
			homeManager.createHome(home);
			electronicDeviceManager.createElectronicDevice(ed);
			personManager.createPerson(person);
			personManager.createPerson(p);
			
			person.setNom("Le nom modifié");
			personManager.update(person);
			
			//test.listPerson();
			System.out.println("Nombre de personne avec Criteria :"+personManager.getPersons().size());
			personManager.showPersons();
			
			System.out.println(personManager.getPerson(2).toString());
			//test.DeletePerson(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}	

}
