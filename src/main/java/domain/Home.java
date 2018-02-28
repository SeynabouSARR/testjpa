package domain;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
/**
 * 
 * @author Seynabou SARR et Melaine BOUE
 *
 */
public class Home {	
   long id;
   long taille;
   long nbrePieces;
   Collection<Heater> heaters;
   Collection<ElectronicDevice> electronicDevices;
/**
 * constructor.
 */
  public Home() { }
/**
 * constructor avec param�tres.
 * @param id: identifiant
 * @param taille : taille
 * @param nbrePieces : nombres pi�ces
 * @param person : personne
 * @param heaters : chauffages
 * @param electronicDevices : les electroniques
 */
  public Home(long id, long taille, long nbrePieces, Person person, Collection<Heater> heaters,Collection<ElectronicDevice> electronicDevices) {
	  super();
	  this.id = id;
	  this.taille = taille;
	  this.nbrePieces = nbrePieces;
	  this.heaters = heaters;
	  this.electronicDevices = electronicDevices;
	  }		
@Id
@GeneratedValue
  public long getId() {
		return id;
		}
  public void setId(long id) {
				this.id = id;
			}			
  public long getTaille() {
	  return taille;
	  }
  public void setTaille(long taille) {
	  this.taille = taille;
	  }	
  public long getNbrePieces() {
	  return nbrePieces;
	  }			
  public void setNbrePieces(long nbrePieces) {
	  this.nbrePieces = nbrePieces;
	  }		
@OneToMany
@JoinColumn(name="home_id")
  public Collection<Heater> getHeaters() {
	  return heaters;
	  }		
  public void setHeaters(Collection<Heater> heaters) {
	  this.heaters = heaters;
	  }			
@OneToMany
@JoinColumn(name="home_id")
  public Collection<ElectronicDevice> getElectronicDevices() {
	  return electronicDevices;
	  }				
  public void setElectronicDevices(Collection<ElectronicDevice> electronicDevices) {
	  this.electronicDevices = electronicDevices;
	  }		
@Override
  public String toString() {
	  return "Home [id=" + id + ", taille=" + taille + ", nbrePieces=" + nbrePieces + ", heaters=" + heaters
						+ ", electronicDevices=" + electronicDevices + "]";
	 }				
}

