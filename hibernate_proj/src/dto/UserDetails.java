package dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

//@Entity(name="USER_DETAILS")
@Entity
@Table(name="USER_DETAILS") //it would give table name which is different from entity name. However, while writing HQL, Entity name would be used
public class UserDetails {
	//@Id
	//@Column(name="USER_ID")  //used if you want to give a different column name corresponding to userId
	@Id  //userId is the primary key of the database
	private int userId;
	//@Column(name="USER_NAME")
	//@Transient //if you do not want to save username in the database
	private String userName;
	@Temporal(TemporalType.DATE)  //if you want to save only date and not the time in the database
	private Date joinedDate;
	private String Address;
	@Lob              //used if your description would go more than 255 varchar length
	private String description;
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	//@Id
	//@Column(name="USER_ID") //taking userId from getter and saving it in the database
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	//@Column(name="USER_NAME")  //taking username from getter and saving it in the database
	public String getUserName() {
		//return userName + " from getter";
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
