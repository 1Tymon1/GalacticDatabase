package io.itch._tymon1.Lab3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ColonyMicroservice {

	public static void main(String[] args) {
		SpringApplication.run(ColonyMicroservice.class, args);
	}

}
