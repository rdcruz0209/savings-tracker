package com.rdcruz.savingstracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.rdcruz.savingstracker.domain.repository"})
@SpringBootApplication
public class SavingsTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SavingsTrackerApplication.class, args);
	}

}
