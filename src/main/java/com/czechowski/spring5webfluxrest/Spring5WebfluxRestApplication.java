package com.czechowski.spring5webfluxrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoAuditing
@EnableMongoRepositories
@SpringBootApplication
public class Spring5WebfluxRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring5WebfluxRestApplication.class, args);
	}
}
