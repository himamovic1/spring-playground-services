package com.sps.spsbff.controller;

import com.sps.spsbff.models.AccountTransactionsResponse;
import com.sps.spsbff.service.ISpsBffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
public class AccountsController {

    @Value("vaulttestvariable")
    private String vaultMessage;

    private final ISpsBffService bffService;

    public AccountsController(ISpsBffService bffService) {
        this.bffService = bffService;
    }


    @GetMapping("/accounts/{accountId}/transactions")
    public AccountTransactionsResponse getAccountTransaction(@PathVariable UUID accountId) {
        log.info("Connection to vault: [{}]", vaultMessage);

        log.info("Fetching account transactions for account id [{}]", accountId);
        return bffService.GetAccountTransactions(accountId);
    }

}
