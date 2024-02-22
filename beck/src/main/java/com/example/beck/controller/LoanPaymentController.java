package com.example.beck.controller;

import com.example.beck.db.Db;
import com.example.beck.dto.LoanPaymentDto;
import com.example.beck.entity.Loan;
import com.example.beck.entity.LoanPayment;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/payments")
@CrossOrigin
public class LoanPaymentController {

    @PostMapping
    public String addLoanPayment(@RequestBody LoanPaymentDto loanPaymentDto){
        UUID customerId = loanPaymentDto.getCustomerId();
        List<Loan> loans = getLoansByUSerId(customerId);
        Double amount = loanPaymentDto.getAmount();
        for (Loan loan : loans) {
            if (loan.calculateRemainingLoan()>=amount){
                if (amount==0){
                    return "you have no money";
                }
                LoanPayment loanPayment=new LoanPayment(
                        UUID.randomUUID(),
                        loan.getId(),
                        amount,
                        LocalDate.now()
                );
                loan.changeStatus();
                Db.loanPayments.add(loanPayment);
            }else {
                LoanPayment loanPayment=new LoanPayment(
                        UUID.randomUUID(),
                        loan.getId(),
                        loan.getAmount(),
                        LocalDate.now()
                );
                Db.loanPayments.add(loanPayment);
                loan.changeStatus();
                amount=amount-loan.getAmount();

            }
        }
        if (amount>0){
            return "zadachi ="+amount;
        }
        return "loan payment added";
    }

    private List<Loan> getLoansByUSerId(UUID customerId){
        List<Loan> loans=new ArrayList<>();
        for (Loan loan : Db.loans) {
            if (loan.getCustomerId().equals(customerId)&&!loan.getStatus()){
                loans.add(loan);
            }
        }
        return loans;
    }

}
