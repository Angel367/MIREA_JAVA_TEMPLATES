package prac19.prac19;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("prac19.prac19.Repositories")
public class Config {
}
