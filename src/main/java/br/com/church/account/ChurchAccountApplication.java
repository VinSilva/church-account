package br.com.church.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ChurchAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChurchAccountApplication.class, args);
	}

}
