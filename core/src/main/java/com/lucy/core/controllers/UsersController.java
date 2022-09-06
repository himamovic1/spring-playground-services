package com.lucy.core.controllers;

import com.lucy.core.models.Transaction;
import com.lucy.core.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
public class UsersController {

    @GetMapping("/users")
    public List<User> GetUsers() {
        log.info("Fetching all users");
        return Collections.singletonList(new User(UUID.randomUUID(), "John", "Doe"));
    }

    @GetMapping("/users/{userId}")
    public User GetUserById(@PathVariable UUID userId) {
        log.info("Fetching a single user by id [{}]", userId);
        return new User(userId, "John", "Doe");
    }

    @GetMapping("/users/{userId}/transactions")
    public List<Transaction> GetUsersTransactions(@PathVariable UUID userId) {
        log.info("Fetching all transactions for a single user by id [{}]", userId);
        return Collections.singletonList(new Transaction(userId, UUID.randomUUID(), 100.0));
    }
}
