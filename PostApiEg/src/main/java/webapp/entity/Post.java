package webapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import webapp.config.Auditable;


@EntityListeners(AuditingEntityListener.class)
@Entity
public class Post extends Auditable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	int id;
	@Column
	String title;
	@Column
	String body;
	@Column
	String description;

	@PrePersist
	public void preInsert() {
		this.description = title + " " + body;
	}

	@PreUpdate
	public void preUpdate() {		
			this.description = title + " " + body;		
	}

	@PreRemove
	public void onPreRemove() {
		

	}

	public Post(int id, String title, String body, String description) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.description = description;
	}

	public Post() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
