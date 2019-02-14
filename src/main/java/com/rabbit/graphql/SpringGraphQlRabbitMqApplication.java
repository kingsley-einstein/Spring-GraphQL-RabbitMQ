package com.rabbit.graphql;

import com.rabbit.graphql.resolvers.Mutation;
import com.rabbit.graphql.resolvers.Query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringGraphQlRabbitMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGraphQlRabbitMqApplication.class, args);
	}

	@Bean
	public Mutation mutation() {
		return new Mutation();
	}

	@Bean
	public Query query() {
		return new Query();
	}

}
