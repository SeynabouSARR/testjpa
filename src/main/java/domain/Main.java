package domain;

import java.util.ArrayList;

import java.util.Collection;


import dao.*;

public class Main{

	public static void main(String[] args) {
		
	    DaoPerson personManager = new DaoPerson(); //Gestionnaire de Person
	    DaoHome homeManager = new DaoHome();  //Gestionnaire de Home
	    DaoHeater heaterManager = new DaoHeater(); //Gestionnaire de Heater
	    DaoElectronicDevice electronicDeviceManager = new DaoElectronicDevice(); //Gestionnaire de ElectronicDevice
	       
		try {
			//Creation et initialisation
	        Collection <Heater> heaters=  new ArrayList<Heater>();
			Heater heater= new Heater();
			heaters.add(heater);
			Collection <Home> homes= new ArrayList<Home>();
			Home home = new Home();
			Collection<ElectronicDevice> electronicDevices = new ArrayList<ElectronicDevice>();
			ElectronicDevice ed= new ElectronicDevice();
			electronicDevices.add(ed);
			Collection<Person> persons = new ArrayList<Person>(); //une liste d'amis
			Person p = new Person("SARR", "Seynabou","13 A rue du Bois Perrin",persons, homes,electronicDevices);
			Collection<Person> pers= new ArrayList<Person>();
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
