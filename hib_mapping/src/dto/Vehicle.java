package dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {
	@Id @GeneratedValue
	private int vehicleId;
	private String vehicleName;
	//@ManyToOne
	//@JoinColumn(name="USER_ID")   //vehicle id and user id will be in the vehicle table. Mapping is in vehicle table
	
	/*@ManyToOne
	  @NotFound(action=NotFoundAction.IGNORE) //to ignore the exception raised in case we do not have user corresponding to a vehicle
	  private UserDetails user;   
	 */
	
	/*@ManyToMany(mappedBy="vehicle")
	private Collection<UserDetails> userList = new ArrayList();
	
	public Collection<UserDetails> getUserList() {
		return userList;
	}
	public void setUserList(Collection<UserDetails> userList) {
		this.userList = userList;
	}*/
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
}
