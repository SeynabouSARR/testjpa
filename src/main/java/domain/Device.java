package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
/**
 * 
 * @author Seynabou SARR et Melaine BOUE
 *
 */
 public class Device {    
	@Id
	@GeneratedValue
	long id;
/**
 * constructor.
 */
    public Device() {
	} 
/**
 * le getteur
 * @return id
 */
  public long getId() {
	  return id;
	  }
/**
 * le setteur	
 * @param id
 */
  public void setId(long id) {
	  this.id = id;
	  }
@Override
  public String toString() {
	return "Devices [id=" + id + "]";
	}
 }
