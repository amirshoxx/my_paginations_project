package com.example.beck.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;
@Data
@AllArgsConstructor
public class CustomerRes {
    private UUID id;
    private String name;
    private Integer age;

    private Double loanAmount;
}
