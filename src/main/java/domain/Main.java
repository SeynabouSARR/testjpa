package domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		
	    Dao test= new Dao();
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
		test.createHeater(heater);
		test.createHome(home);
		test.createElectronicDevice(ed);
		test.createPerson(person);
		test.createPerson(p);
		//test.listPerson();
		test.listPersons();
		//test.DeletePerson(p);
	} catch (Exception e) {
		e.printStackTrace();
	}
		test.close();
	}	

}
