package webapp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;




import webapp.config.Auditable;


@Entity
public class Logger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	int id;
	String entityName;
	String beforeSnapshot;
	String afterSnapshot;
	String userId;
	String action;
	String firstName;
	String lastName;
	String userName;
	@CreatedDate
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")

	Date createdDate;
	
	public Logger() {
		super();
	}
	public Logger(int id, String entityName, String beforeSnapshot, String afterSnapshot, String userId, String action,
			String firstName, String lastName, String userName, Date createdDate) {
		super();
		this.id = id;
		this.entityName = entityName;
		this.beforeSnapshot = beforeSnapshot;
		this.afterSnapshot = afterSnapshot;
		this.userId = userId;
		this.action = action;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.createdDate = createdDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public String getBeforeSnapshot() {
		return beforeSnapshot;
	}
	public void setBeforeSnapshot(String beforeSnapshot) {
		this.beforeSnapshot = beforeSnapshot;
	}
	public String getAfterSnapshot() {
		return afterSnapshot;
	}
	public void setAfterSnapshot(String afterSnapshot) {
		this.afterSnapshot = afterSnapshot;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "Logger [id=" + id + ", entityName=" + entityName + ", beforeSnapshot=" + beforeSnapshot
				+ ", afterSnapshot=" + afterSnapshot + ", userId=" + userId + ", action=" + action + ", firstName="
				+ firstName + ", lastName=" + lastName + ", userName=" + userName + ", createdDate=" + createdDate
				+ "]";
	}
		
	
}
