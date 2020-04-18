package com.spring.reactive.mongo.handler;

import com.spring.reactive.mongo.model.Customer;
import com.spring.reactive.mongo.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CustomerHandler {

	@Autowired
	private CustomerRepository repository;

	public Mono<ServerResponse> getAll(ServerRequest request) {
		Flux<Customer> customer = repository.findAll();
		return ServerResponse.ok().body(BodyInserters.fromPublisher(customer, Customer.class));
	}

	public Mono<ServerResponse> getById(ServerRequest request) {
		Mono<Customer> customer = repository.findById(request.pathVariable("id"));
		return ServerResponse.ok().body(BodyInserters.fromPublisher(customer, Customer.class));
	}

	public Mono<ServerResponse> create(ServerRequest request) {
		Flux<Customer> insert = repository.insert(request.bodyToMono(Customer.class));
		return ServerResponse.ok().body(BodyInserters.fromPublisher(insert, Customer.class));
	}
}
