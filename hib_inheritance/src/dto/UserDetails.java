package dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="USER_DETAILS") //it would give table name which is different from entity name. However, while writing HQL, Entity name would be used
public class UserDetails {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)  //Id annotation specifies userId is the primary key of the database
	private int userId;
	private String userName;
	//@OneToOne                        //One to One Mapping
	//@JoinColumn(name="VEHICLE_ID")
	//private Vehicle vehicle;
	//@OneToMany
	//@JoinTable(name="USER_VEHICLE",joinColumns=@JoinColumn(name="USER_ID"),
	//								inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))
	//@OneToMany(mappedBy="user") //it would specify that the mapping would be made at the vehicle side by the user object defined in the vehicle class

	//@ManyToMany
	@OneToMany(cascade=CascadeType.PERSIST)  //tutorial for CASCADE....
	private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();
	

	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
