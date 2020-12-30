
package webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
class JpaAuditingConfiguration {

	@Bean
	public AuditorAware<String> auditorProvider() {
		// TODO: Update/Delete return of auditorProvider
		return () -> Optional.ofNullable("ABC");
	}
}