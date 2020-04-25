package com.spring.reactive.mongo.controller;

import com.spring.reactive.mongo.service.CustomerService;
import com.spring.reactive.mongo.model.Customer;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customers")
@Log4j
public class CustomerController {

    @Autowired
    private CustomerService customerHandler;

    @PostMapping
    public void createCustomer(@RequestBody Customer customer){
        log.info("Customer object is received");
        customerHandler.create(customer);
    }

    @GetMapping
    public Flux<Customer> getAllCustomers(){
        log.info("All customers is sending");
        return customerHandler.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Customer> getCustomerById(@PathVariable String id){
        log.info("Customer by id is called");
        return customerHandler.getById(id);
    }
}
