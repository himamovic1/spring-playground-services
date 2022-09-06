package com.lucy.core.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Transaction {
    private UUID id;
    private UUID userId;
    private Double amount;
}
