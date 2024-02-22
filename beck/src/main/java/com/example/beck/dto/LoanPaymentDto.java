package com.example.beck.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class LoanPaymentDto {
    private UUID customerId;
    private Double amount;

}
