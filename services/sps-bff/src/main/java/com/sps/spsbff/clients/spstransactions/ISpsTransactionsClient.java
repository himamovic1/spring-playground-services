package com.sps.spsbff.clients.spstransactions;

import com.sps.spsbff.clients.spstransactions.models.Transaction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "sps-transactions-client", url = "sps-transactions:18080")
public interface ISpsTransactionsClient {

    @RequestMapping(
        method = RequestMethod.GET,
        value = "/transactions",
        produces = "application/json")
    List<Transaction> getTransactions();

}
