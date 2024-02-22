package com.example.beck.controller;

import com.example.beck.db.Db;
import com.example.beck.entity.Customer;
import com.example.beck.responses.CustomerRes;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping
    public List<CustomerRes> getCustomer(){
        List<CustomerRes> customerRes=new ArrayList<>();
        for (Customer customer : Db.customers) {
            customerRes.add(new CustomerRes(
                    customer.getId(),
                    customer.getName(),
                    customer.getAge(),
                    customer.calculateLoan()
            ));
        }
        return customerRes;
    }

}
