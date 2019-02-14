package com.rabbit.graphql.resolvers;

import java.util.UUID;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.rabbit.graphql.model.User;
import com.rabbit.graphql.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public User newUser(final String username, final String password) {
        User user = new User(username, encoder.encode(password),
                BCrypt.hashpw(UUID.fromString(username).toString(), UUID.randomUUID().toString()));

        return userRepository.save(user);
    }

    public User updatePassword(final Long id, final String password) {
        User user = userRepository.findOne(id);
        user.setPassword(encoder.encode(password));

        return userRepository.save(user);
    }
}