package com.rabbit.graphql.auth;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rabbit.graphql.model.User;

import graphql.servlet.GraphQLContext;

public class AuthContext extends GraphQLContext {

    private User user;

    public AuthContext(Optional<HttpServletRequest> request, Optional<HttpServletResponse> response, final User user) {
        super(request, response);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}