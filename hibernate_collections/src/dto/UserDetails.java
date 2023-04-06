package dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
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
	//-----------Saving Collections-------------
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="USER_ADDRESS",
				joinColumns=@JoinColumn(name="USER_ID"))
	//@GenericGenerator(name="hilo-gen", strategy="hilo")
	//@CollectionId(columns={@Column(name="ADDRESS_ID")}, generator="hilo-gen", type=@Type(type="long")) //hibernate specific annotation, not a JPA(javax persistence)
	private Collection<Address> listOfAddresses = new ArrayList<Address>();
	public int getUserId() {
		return userId;
	}
	

	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}


	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
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
