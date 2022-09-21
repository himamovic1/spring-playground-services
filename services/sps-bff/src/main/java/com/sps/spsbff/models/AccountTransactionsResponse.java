package com.sps.spsbff.models;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class AccountTransactionsResponse {
    private UUID accountId;
    private List<Transaction> transactions;
}
