package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ElectronicDevice extends Devices{
	long consMoyenne;
	public ElectronicDevice() {
		
	}
	public ElectronicDevice( long consMoyenne) {
		this.consMoyenne = consMoyenne;
	}
	public long getConsMoyenne() {
		return consMoyenne;
	}
	public void setConsMoyenne(long consMoyenne) {
		this.consMoyenne = consMoyenne;
	}
	
	

}
