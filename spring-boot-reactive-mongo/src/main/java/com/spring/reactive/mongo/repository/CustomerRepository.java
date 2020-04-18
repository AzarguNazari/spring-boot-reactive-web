package com.spring.reactive.mongo.repository;

import com.spring.reactive.mongo.model.Customer;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {

	Flux<Customer> findByLastName(String lastName);

	@Query("{'lastName' : ?0, 'firstName' : ?1}")
	Mono<Customer> findByLastAndFirstName(String lastName, String firstName);
}
