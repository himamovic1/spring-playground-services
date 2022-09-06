package com.lucy.core.controllers;

import com.lucy.core.models.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
public class TransactionsController {

    @GetMapping("/transactions")
    public List<Transaction> GetTransactions() {
        log.info("Fetching all transactions");
        return Collections.singletonList(new Transaction(UUID.randomUUID(), UUID.randomUUID(), 100.0));
    }

    @GetMapping("/transactions/{transactionId}")
    public Transaction GetTransaction(@PathVariable UUID transactionId) {
        log.info("Fetching a single transaction by id [{}]", transactionId);
        return new Transaction(transactionId, UUID.randomUUID(), 100.0);
    }
}
