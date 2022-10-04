package com.sps.spsbff.clients.spsaccounts.models;

import lombok.Data;

import java.util.UUID;

@Data
public class Account {
    private UUID id;
    private User user;
    private Double balance;
}
