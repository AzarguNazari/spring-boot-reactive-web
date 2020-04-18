# Spring Boot Reactive MongoDB
This sample project shows usage of spring-data reactive concepts for MongoDB

## Prerequisites
* Install [MongoDB](http://www.mongodb.org/downloads)
* run `./mongod --dbpath <path-to-data>`
* the DB uri is configured in the `application.properties`

## Addressed concepts
* initialization of data when starting application within `DataInitialization` class
* routing RESTful endpoints with webflux as done in `RoutesConfig`
* using reactive repositories like `CustomerRepository`
* enabling MongoDB auditing with `@EnableMongoAuditing`
* using auditing fields like `@CreatedDate` as used in `Customer` class 