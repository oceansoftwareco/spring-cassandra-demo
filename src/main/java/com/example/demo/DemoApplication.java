package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDateTime;
import java.util.*;

@SpringBootApplication
public class DemoApplication {
	static Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		VetRepository vetRepository = context.getBean(VetRepository.class);

		vetRepository.deleteAll();

		Vet first = new Vet(new VetKey("ivan", LocalDateTime.now(), UUID.randomUUID()), "ivanov", Set.of("first", "second"));
		Vet first2 = new Vet(new VetKey("ivan", LocalDateTime.now(), UUID.randomUUID()), "ivanov", Set.of("first", "second"));
		Vet first3 = new Vet(new VetKey("ivan", LocalDateTime.now(), UUID.randomUUID()), "ivanov", Set.of("first", "second"));
		Vet second = new Vet(new VetKey("gancho", LocalDateTime.now().minusDays(1), UUID.randomUUID()), "genchev", Set.of("first", "second"));

		vetRepository.save(first);
		vetRepository.save(first2);
		vetRepository.save(first3);
		vetRepository.save(second);

		vetRepository.findByKeyFirstName("ivan").forEach(vet -> logger.info(vet.getLastName()));

		vetRepository.findByKeyFirstNameAndLastName("ivan", "ivanov").forEach(vet -> logger.info(vet.getLastName()));
	}
}
