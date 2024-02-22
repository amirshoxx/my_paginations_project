package com.example.beck.entity;

import com.example.beck.db.Db;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Customer {

    private UUID id;
    private String name;
    private Integer age;

    public Double calculateLoan(){
        double amount=0;
        for (Loan loan : Db.loans) {
            if (loan.getCustomerId().equals(id)){
                amount+=loan.calculateRemainingLoan();
            }
        }

        return amount;
    }

}
