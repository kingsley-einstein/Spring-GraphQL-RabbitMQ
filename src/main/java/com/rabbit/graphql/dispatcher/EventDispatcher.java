package com.rabbit.graphql.dispatcher;

import com.rabbit.graphql.model.User;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EventDispatcher {
    @Autowired
    private RabbitTemplate template;

    @Value("${exchanger.id}")
    private String exchangerId;

    @Value("${exchanger.routeKey}")
    private String exchangerRoute;

    public void send(User user) {
        template.convertAndSend(exchangerId, exchangerRoute, user);
    }
}