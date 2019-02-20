package com.rabbit.graphql.auth;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rabbit.graphql.model.User;
import com.rabbit.graphql.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;

import graphql.schema.GraphQLSchema;
import graphql.servlet.GraphQLContext;
import graphql.servlet.SimpleGraphQLServlet;

public class AuthServlet extends SimpleGraphQLServlet {
    private static final long serialVersionUID = 1L;

    @Autowired
    private UserRepository userRepository;

    public AuthServlet() {
        super(new GraphQLSchema(null));
    }

    @Override
    public GraphQLContext createContext(Optional<HttpServletRequest> request, Optional<HttpServletResponse> response) {
        User user = request.map(req -> req.getHeader("Authorization")).filter(auth -> !auth.isEmpty())
                .map(auth -> auth.split(" ")).map(auth -> userRepository.findByToken(auth[1])).orElse(null);

        return new AuthContext(request, response, user);
    }
}