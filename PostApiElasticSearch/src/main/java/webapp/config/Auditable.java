package webapp.config;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable<U> {
	
	@CreatedDate
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createdDate;

	@LastModifiedDate
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	protected Date lastModifiedDate;	
	
}