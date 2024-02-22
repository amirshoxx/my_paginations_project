package com.example.beck.entity;

import com.example.beck.db.Db;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Loan {
    private UUID id;
    private UUID customerId;
    private Double amount;
    private Boolean status;
    private LocalDate localDate;

    public void changeStatus(){
        if (calculateRemainingLoan()==0){
            status=true;
        }
    }

    public Double calculateRemainingLoan(){
        return amount-sumPaymentsOfLoan();
    }

    public Double sumPaymentsOfLoan(){
        double x=0;
        for (LoanPayment loanPayment : Db.loanPayments) {
            if (loanPayment.getLoanId().equals(id)){
                x+=loanPayment.getAmount();
            }
        }
        return x;
    }

}
