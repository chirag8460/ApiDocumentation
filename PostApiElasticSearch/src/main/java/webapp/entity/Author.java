package webapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class Author extends Auditable<String>{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@Column
	private String name;

	
	/*
	 * @PrePersist public void onPrePersist() { setOperation("Insert");
	 * setTimeStamp((new Date().getTime())+"");
	 * 
	 * }
	 * 
	 * @PreUpdate public void onPreUpdate() { setOperation("Update");
	 * setTimeStamp((new Date().getTime())+""); }
	 * 
	 * @PreRemove public void onPreRemove() { setOperation("Remove");
	 * setTimeStamp((new Date().getTime())+""); }
	 */

}
