package com.example.beck.controller;

import com.example.beck.db.Db;
import com.example.beck.dto.LoanDto;
import com.example.beck.entity.Loan;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/loans")
@CrossOrigin
public class LoanController {

    @PostMapping
    public String addLoan(@RequestBody LoanDto loanDto){
        Db.loans.add(new Loan(
                UUID.randomUUID(),
                loanDto.getCustomerId(),
                loanDto.getAmount(),
                false,
                LocalDate.now()
        ));
        return "loan added ";
    }

    @GetMapping
    public List<Loan> getLoans(@RequestParam(defaultValue = "") UUID userId){
        List<Loan> loans=new ArrayList<>();
        for (Loan loan : Db.loans) {
            if (loan.getCustomerId().equals(userId)){
                loans.add(loan);
            }
        }
        return loans;
    }

}
