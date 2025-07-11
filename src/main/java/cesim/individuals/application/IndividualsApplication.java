package cesim.individuals.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"cesim.individuals.*"})
@EnableJpaRepositories("cesim.individuals.**")
@EntityScan("cesim.individuals.**")
@EnableScheduling
public class IndividualsApplication {
	public static void main(String[] args) {
		SpringApplication.run(IndividualsApplication.class, args);
	}
}
