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
		
	    DaoPerson personManager = new DaoPerson(); //Gestionnaire de Person
	    DaoDevice deviceManager = new DaoDevice(); //Gestionnaire de Device
	    DaoHome homeManager = new DaoHome();  //Gestionnaire de Home
	    DaoHeater heaterManager = new DaoHeater(); //Gestionnaire de Heater
	    DaoElectronicDevice electronicDeviceManager = new DaoElectronicDevice(); //Gestionnaire de ElectronicDevice
	    
	    
		try {
			//Creation et initialisation
	        Collection <Heater> heaters=  new ArrayList();
			Heater heater= new Heater();
			heaters.add(heater);
			Collection <Home> homes= new ArrayList();
			Home home = new Home();
			Collection<ElectronicDevice> electronicDevices = new ArrayList();
			ElectronicDevice ed= new ElectronicDevice();
			electronicDevices.add(ed);
			Collection<Person> persons = new ArrayList(); //une liste d'amis
			Person p = new Person("SARR", "Seynabou","13 A rue du Bois Perrin",persons, homes,electronicDevices);
			Collection<Person> pers= new ArrayList();
			Person person= new Person("BOUE", "MELAINE","BOIS PERRIN", null, null, null);
			persons.add(person); 
			pers.add(p);
			pers.add(person);
			
			//Ajout des elements dans la base de données
			heaterManager.createHeater(heater); 
			homeManager.createHome(home);  
			electronicDeviceManager.createElectronicDevice(ed);
			personManager.createPerson(person);
			personManager.createPerson(p);
			
			person.setNom("Le nom modifié");
			personManager.update(person); //mis à jour du nom dans la base de données
			
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
