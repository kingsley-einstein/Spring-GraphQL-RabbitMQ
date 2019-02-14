package com.rabbit.graphql.resolvers;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.rabbit.graphql.auth.AuthContext;
import com.rabbit.graphql.model.User;
import com.rabbit.graphql.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetchingEnvironment;

@Component
public class Query implements GraphQLQueryResolver {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DataFetchingEnvironment dataFetchingEnvironment;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.findOne(id);
    }

    public User getByToken(String token) {
        return userRepository.findByToken(token);
    }

    public User getUserFromHeader() {
        AuthContext context = dataFetchingEnvironment.getContext();

        return context.getUser();
    }
}