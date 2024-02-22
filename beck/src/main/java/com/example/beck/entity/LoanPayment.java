package com.example.beck.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
public class LoanPayment {
    private UUID id;
    private UUID loanId;
    private Double amount;
    private LocalDate localDate;
}
