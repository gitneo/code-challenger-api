package com.cron.codechallenger;

import com.cron.codechallenger.data.repositories.PlayerRepository;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = PlayerRepository.class)
@EnableEncryptableProperties
public class CodeChallengerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeChallengerApplication.class, args);
	}

}
