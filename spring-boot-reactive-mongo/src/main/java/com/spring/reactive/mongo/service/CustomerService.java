package com.spring.reactive.mongo.service;

import com.spring.reactive.mongo.model.Customer;
import com.spring.reactive.mongo.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CustomerService {

	@Autowired
	private CustomerRepository repository;

	public Flux<Customer> getAll() {
		return repository.findAll();
	}

	public Mono<Customer> getById(String id) {
		return repository.findById(id);
	}

	public void create(Customer customer) {
		repository.insert(Mono.just(customer));
	}
}
