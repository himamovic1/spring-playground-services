package com.sps.spsaccounts.controllers;

import com.sps.spsaccounts.models.Account;
import com.sps.spsaccounts.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
public class AccountsController {

    @GetMapping("/accounts")
    public List<Account> GetAccounts() {
        log.info("Fetching all accounts");

        var user1 = new User(UUID.randomUUID(), "John", "Doe");
        var account1 = new Account(UUID.randomUUID(), user1, 152.35d);

        var user2 = new User(UUID.randomUUID(), "Jane", "Doe");
        var account2 = new Account(UUID.randomUUID(), user2, 453.35d);

        return List.of(account1, account2);
    }

    @GetMapping("/accounts/{accountId}")
    public Account GetAccountById(@PathVariable UUID accountId) {
        log.info("Fetching a single account by id [{}]", accountId);

        var user = new User(UUID.randomUUID(), "John", "Doe");
        var account = new Account(accountId, user, 152.35d);

        return account;
    }
}
