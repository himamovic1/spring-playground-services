package com.sps.spsaccounts.controllers;

import com.netflix.discovery.EurekaClient;
import com.sps.spsaccounts.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
public class UsersController {

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    private EurekaClient eurekaClient;


    @GetMapping("/users")
    public List<User> GetUsers() {
        log.info("Processing on app [{}]", eurekaClient.getApplication(appName));

        log.info("Fetching all users");
        return Collections.singletonList(new User(UUID.randomUUID(), "John", "Doe"));
    }

    @GetMapping("/users/{userId}")
    public User GetUserById(@PathVariable UUID userId) {
        log.info("Processing on app [{}]", eurekaClient.getApplication(appName));

        log.info("Fetching a single user by id [{}]", userId);
        return new User(userId, "John", "Doe");
    }
}