package com.cron.codechallenger;

import com.cron.codechallenger.data.repositories.PlayerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = PlayerRepository.class)
public class CodeChallengerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeChallengerApplication.class, args);
	}

}
