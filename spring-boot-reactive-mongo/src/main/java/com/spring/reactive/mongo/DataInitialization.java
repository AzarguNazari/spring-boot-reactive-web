package com.spring.reactive.mongo;

import com.spring.reactive.mongo.model.Customer;
import com.spring.reactive.mongo.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@Slf4j
public class DataInitialization implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	@Override
	public void run(String... args) {
		log.info("starting data init...");

		Customer donald = Customer.builder()
				.firstName("Donald").lastName("Duck")
				.email("donald@test.com").build();

		Customer mickey = Customer.builder()
				.firstName("Mickey").lastName("Mouse")
				.email("mickey@test.com").build();

		repository.deleteAll().thenMany(
				Flux.just(donald, mickey)
				.flatMap(c -> repository.save(c))
		).subscribe( null,
				throwable ->  log.error("Could not save customer", throwable ),
		() -> log.info("Finished data init..."));

		repository.count().subscribe(c -> log.info("Inserted " + c + " customers!"));
	}
}
