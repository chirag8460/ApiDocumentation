package webapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import webapp.config.Auditable;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Logger extends Auditable<String> {
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
	@PrePersist
	public void setPrePersist() {
		
	}
	@PostPersist
	public void setPostPersist() {
		
	}
	
}
