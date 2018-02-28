package domain;

import javax.persistence.Entity;

@Entity
/**
 * 
 * @author Seynabou SARR et Melaine BOUE
 *
 */
public class ElectronicDevice extends Device {
	long consMoyenne;
/**
 * contructor.
 */
  public ElectronicDevice() {
		consMoyenne=0;		
	}
 /**
  * constructor avec param.
  * @param consMoyenne
  */
  public ElectronicDevice( long consMoyenne) {
	  this.consMoyenne = consMoyenne;
	  }	
/**
 * le getteur
 * @return consMoyenne
 */
  public long getConsMoyenne(){
	  return consMoyenne;
	  }	
/**
 * le setteur
 * @param consMoyenne : la consommation moyenne
 */
  public void setConsMoyenne(long consMoyenne) {
		this.consMoyenne = consMoyenne;
		}	
@Override
  public String toString() {
		return "ElectronicDevice [consMoyenne=" + consMoyenne + "]";
		}
}
