package com.sps.spsbff.service;

import com.sps.spsbff.clients.spstransactions.ISpsTransactionsClient;
import com.sps.spsbff.models.AccountTransactionsResponse;
import com.sps.spsbff.models.Transaction;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

@Service
public class SpsBffService implements ISpsBffService {

    private final ISpsTransactionsClient transactionsClient;

    public SpsBffService(ISpsTransactionsClient transactionsClient) {
        this.transactionsClient = transactionsClient;
    }


    @Override
    public AccountTransactionsResponse GetAccountTransactions(UUID accountId) {
        var transactions = transactionsClient.getTransactions();

        // Map to API models
        var apiTransactions = Optional.ofNullable(transactions)
            .orElse(Collections.emptyList()).stream()
            .map(t -> new Transaction(t.getId(), t.getIban(), t.getAmount()))
            .toList();

        var response = new AccountTransactionsResponse();
        response.setTransactions(apiTransactions);
        response.setAccountId(accountId);

        return response;
    }

}
