package webapp.entity;



import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import webapp.config.Auditable;



@Document(indexName = "logs")

public class Log  {
	@Id	
	int id;	
	String entityName;
	String action;
	String beforeSnapshot;
	String firstName;
	String lastName;
	String userName;	
	String afterSnapshot;	
	String userId;
	
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	protected Date createdDate;
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
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getBeforeSnapshot() {
		return beforeSnapshot;
	}
	public void setBeforeSnapshot(String beforeSnapshot) {
		this.beforeSnapshot = beforeSnapshot;
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
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Log(int id, String entityName, String action, String beforeSnapshot, String firstName, String lastName,
			String userName, String afterSnapshot, String userId, Date createdDate) {
		super();
		this.id = id;
		this.entityName = entityName;
		this.action = action;
		this.beforeSnapshot = beforeSnapshot;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.afterSnapshot = afterSnapshot;
		this.userId = userId;
		this.createdDate = createdDate;
	}
	public Log() {
		super();
	}
	
	
}
