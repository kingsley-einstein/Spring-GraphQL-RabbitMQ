package com.rabbit.graphql;

import java.util.List;
import java.util.Map;

//import com.rabbit.graphql.auth.AuthServlet;
import com.rabbit.graphql.resolvers.Mutation;
import com.rabbit.graphql.resolvers.Query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import graphql.execution.ExecutionId;
import graphql.execution.ExecutionTypeInfo;
import graphql.language.Field;
import graphql.language.FragmentDefinition;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.DataFetchingFieldSelectionSet;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLOutputType;
import graphql.schema.GraphQLSchema;
import graphql.schema.GraphQLType;

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

	@Bean
	public DataFetchingEnvironment dataFetchingEnvironment() {
		return new DataFetchingEnvironment() {

			@Override
			public <T> T getSource() {
				return null;
			}

			@Override
			public DataFetchingFieldSelectionSet getSelectionSet() {
				return null;
			}

			@Override
			public <T> T getRoot() {
				return null;
			}

			@Override
			public GraphQLType getParentType() {
				return null;
			}

			@Override
			public GraphQLSchema getGraphQLSchema() {
				return null;
			}

			@Override
			public Map<String, FragmentDefinition> getFragmentsByName() {
				return null;
			}

			@Override
			public List<Field> getFields() {
				return null;
			}

			@Override
			public ExecutionTypeInfo getFieldTypeInfo() {
				return null;
			}

			@Override
			public GraphQLOutputType getFieldType() {
				return null;
			}

			@Override
			public GraphQLFieldDefinition getFieldDefinition() {
				return null;
			}

			@Override
			public ExecutionId getExecutionId() {
				return null;
			}

			@Override
			public <T> T getContext() {
				return null;
			}

			@Override
			public Map<String, Object> getArguments() {
				return null;
			}

			@Override
			public <T> T getArgument(String arg0) {
				return null;
			}

			@Override
			public boolean containsArgument(String arg0) {
				return false;
			}
		};
	}

}
