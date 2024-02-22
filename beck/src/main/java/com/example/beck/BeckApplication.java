package com.example.beck;

import com.example.beck.db.Db;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeckApplication {

    public static void main(String[] args) {
        Db.init();
        SpringApplication.run(BeckApplication.class, args);
    }

}
