package com.sps.spsbff.clients.spstransactions.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Transaction {
    private UUID id;
    private String iban;
    private Double amount;
}
