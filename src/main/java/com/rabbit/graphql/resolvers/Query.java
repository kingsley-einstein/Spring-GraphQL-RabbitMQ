package com.rabbit.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.rabbit.graphql.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    @Autowired
    private UserRepository userRepository;
}