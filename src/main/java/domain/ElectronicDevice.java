package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ElectronicDevice extends Device{
	
	long consMoyenne;
	public ElectronicDevice() {
		consMoyenne=0;
		
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
	
	
	@Override
	public String toString() {
		return "ElectronicDevice [consMoyenne=" + consMoyenne + "]";
	}
	

}
