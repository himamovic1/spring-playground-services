package com.sps.spsbff.models;

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
