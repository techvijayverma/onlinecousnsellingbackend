package org.cdac.onlinecounselingbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"org.cdac.controllers","org.cdac.services"})
@EnableJpaRepositories(basePackages="org.cdac.repositories")
@EntityScan(basePackages="org.cdac.entity")
public class OnlinecounselingbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinecounselingbackendApplication.class, args);
	}

}
