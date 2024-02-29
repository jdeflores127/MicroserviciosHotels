package com.aleal.apigateway;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import io.opentelemetry.instrumentation.spring.autoconfigure.EnableOpenTelemetry;

@EnableOpenTelemetry
@SpringBootApplication
public class ApigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigatewayApplication.class, args);
	}
	
	@Bean
	RouteLocator rutas(RouteLocatorBuilder builder) {
		//El path va a ser cualquier nombre con el que se quiera enmascarar el API
		//Se rescribe el path
		return builder.routes()
				.route(r->r.path("/applications/apihotel/**")
						.filters(f->f.rewritePath("/applications/apihotel/(?<segment>.*)", "/${segment}")
									.addResponseHeader("X-Response-Time", new Date().toString()))
						.uri("lb://HOTELS"))
				.route(r->r.path("/applications/apirooms/**")
						.filters(f->f.rewritePath("/applications/apirooms/(?<segment>.*)", "/${segment}")
									.addResponseHeader("X-Response-Time", new Date().toString()))
						.uri("lb://ROOMS"))
				.route(r->r.path("/applications/apireservations/**")
						.filters(f->f.rewritePath("/applications/apireservations/(?<segment>.*)", "/${segment}")
									.addResponseHeader("X-Response-Time", new Date().toString()))
						.uri("lb://RESERVATIONS"))
				.build();
	}
}
