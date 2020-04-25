//package com.spring.reactive.mongo.configuration;
//
//import com.spring.reactive.mongo.handler.CustomerHandler;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.reactive.function.server.RouterFunction;
//import org.springframework.web.reactive.function.server.ServerResponse;
//
//import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
//import static org.springframework.web.reactive.function.server.RouterFunctions.route;
//
//@Configuration
//public class RoutesConfig {
//
//	@Bean
//	RouterFunction<ServerResponse> routes(CustomerHandler handler) {
//
//		return route(GET("/customer"),
//							request -> handler.getAll(request))
//
//				.and(route(GET("/customer/{id}"),
//								request -> handler.getById(request)));
//	}
//}
