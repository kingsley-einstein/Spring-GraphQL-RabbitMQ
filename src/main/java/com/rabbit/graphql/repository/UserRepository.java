package com.rabbit.graphql.repository;

import com.rabbit.graphql.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByToken(String token);
}