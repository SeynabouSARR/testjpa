package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Devices {
    
	@Id
	@GeneratedValue
	long id;
   public Devices() {
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Devices [id=" + id + "]";
	}

	

}
