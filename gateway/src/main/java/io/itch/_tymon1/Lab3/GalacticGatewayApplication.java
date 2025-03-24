package io.itch._tymon1.Lab3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GalacticGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GalacticGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(
			RouteLocatorBuilder builder,
			@Value("${rpg.colony.url}") String colonyUrl,
			@Value("${rpg.empire.url}") String empireUrl,
			@Value("${rpg.gateway.host}") String host
	) {
		return builder
				.routes()
				.route("empires", route -> route
						.host(host)
						.and()
						.path(
								"/api/empires/{uuid}",
								"/api/empires"
						)
						.uri(empireUrl)
				)
				.route("colonies", route -> route
						.host(host)
						.and()
						.path(
								"/api/colonies",
								"/api/colonies/**",
								"/api/users/{uuid}/colonies",
								"/api/users/{uuid}/colonies/**",
								"/api/empires/{uuid}/colonies",
								"/api/empires/{uuid}/colonies/**"
						)
						.uri(colonyUrl)
				)
				.build();
	}
}
