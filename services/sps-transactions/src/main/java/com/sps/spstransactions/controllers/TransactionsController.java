package com.sps.spstransactions.controllers;

import com.sps.spstransactions.models.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
public class TransactionsController {

    @GetMapping("/transactions")
    public List<Transaction> GetTransactions() {
        log.info("Fetching all transactions");

        var accountId = UUID.randomUUID().toString();
        var trx1 = new Transaction(UUID.randomUUID(), accountId, 10.9);
        var trx2 = new Transaction(UUID.randomUUID(), accountId, 20.9);
        var trx3 = new Transaction(UUID.randomUUID(), accountId, 30.9);

        return List.of(trx1, trx2, trx3);
    }

    @GetMapping("/transactions/{transactionId}")
    public Transaction GetTransaction(@PathVariable UUID transactionId) {
        log.info("Fetching a single transaction by id [{}]", transactionId);

        var accountId = UUID.randomUUID().toString();
        return new Transaction(transactionId, accountId, 10.9);
    }

}
