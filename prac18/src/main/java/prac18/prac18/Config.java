package prac18.prac18;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("prac18.prac18.Repositories")
public class Config {
}
