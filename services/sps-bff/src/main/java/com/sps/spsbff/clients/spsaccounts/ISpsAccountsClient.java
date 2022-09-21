package com.sps.spsbff.clients.spsaccounts;

import com.sps.spsbff.clients.spsaccounts.models.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "sps-accounts")
public interface ISpsAccountsClient {

    @RequestMapping(
        method = RequestMethod.GET,
        value = "/accounts",
        produces = "application/json")
    List<Account> getAccounts();

    @RequestMapping(
        method = RequestMethod.GET,
        value = "/accounts/{accountId}",
        produces = "application/json")
    Account getAccountById(@PathVariable("accountId") UUID accountId);


    @RequestMapping(
        method = RequestMethod.GET,
        value = "/users",
        produces = "application/json")
    List<Account> getUsers();

    @RequestMapping(
        method = RequestMethod.GET,
        value = "/users/{userId}",
        produces = "application/json")
    Account getUserById(@PathVariable("userId") UUID userId);

}
