package com.tallninja.springrestclient;

import com.tallninja.springrestclient.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class SpringRestClientApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringRestClientApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringRestClientApplication.class, args);
	}

	@Bean
	public RestTemplate apiClient(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate apiClient) throws Exception {
		return args -> {
			User user = apiClient.getForObject("https://jsonplaceholder.typicode.com/users/1", User.class);
			if (user != null) {
				log.info(user.toString());
			} else {
				log.error("User not found");
			}
		};
	}
}
