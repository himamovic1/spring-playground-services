package com.sps.spsbff.service;

import com.sps.spsbff.models.AccountTransactionsResponse;

import java.util.UUID;

public interface ISpsBffService {
    AccountTransactionsResponse GetAccountTransactions(UUID accountId);
}
