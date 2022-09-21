package com.sps.spsbff.service;

import com.sps.spsbff.models.AccountTransactionsResponse;
import com.sps.spsbff.models.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SpsBffService implements ISpsBffService {

    @Override
    public AccountTransactionsResponse GetAccountTransactions(UUID accountId) {
        var trx1 = new Transaction(UUID.randomUUID(), accountId, 10.9);
        var trx2 = new Transaction(UUID.randomUUID(), accountId, 20.9);
        var trx3 = new Transaction(UUID.randomUUID(), accountId, 30.9);

        var response = new AccountTransactionsResponse();
        response.setTransactions(List.of(trx1, trx2, trx3));
        response.setAccountId(accountId);

        return response;
    }

}
