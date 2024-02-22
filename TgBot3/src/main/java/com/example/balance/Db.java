package com.example.balance;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class Db {
    static List<User> users = new ArrayList<>();
    static List<Income> incomes = new ArrayList<>();
    static List<Expense> expenses = new ArrayList<>();

    static public int allIncomes() {
        int counter = 0;
        for (Income income:
                incomes) {
            counter=counter+income.amount;
        }
        return counter;
    }

    static public int allExpenses() {
        int counter = 0;
        for (Expense expense:
             expenses) {
            counter=counter+expense.amount;
        }
        return counter;
    }

    public static int allBalance() {
        return allIncomes()-allExpenses();
    }
}
