package com.sps.spsbff.clients.spsaccounts.models;

import lombok.Data;

import java.util.UUID;

@Data
public class User {
    private UUID id;
    private String name;
    private String lastName;
}
