package com.example.demo.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import org.springframework.stereotype.Component;

@Component
public class Routes {
//	@Bean
//	public RouterFunction<ServerResponse> productServiceRoute(){
//		return GatewayRouterFunctions.route("QUIZ-SERVICE")
//				.route(RequestPredicates.path("/api"), HandlerFunctions.http("http://localhost:8081"))
//				.build();
//	}
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes().route(f->f.path("/gateway/quiz/**")
				.filters(p-> p.rewritePath("/gateway/(?<segment>.*)", "/api/${segment}"))
				.uri("http://localhost:8081")).build();
	}
	
	@Bean
	public RouteLocator myRoutes1(RouteLocatorBuilder builder) {
		return builder.routes().route(f->f.path("/gateway/question/**")
				.filters(p-> p.rewritePath("/gateway/(?<segment>.*)", "/api/${segment}"))
				.uri("http://localhost:8082")).build();
	}
}
