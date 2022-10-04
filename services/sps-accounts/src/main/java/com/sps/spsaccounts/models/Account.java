package com.sps.spsaccounts.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Account {

    @NotNull
    private UUID id;

    @NotNull
    private User user;

    @NotNull
    private Double balance;

}
