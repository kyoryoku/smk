package lab.smk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class SmkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmkApplication.class, args);
	}

}
