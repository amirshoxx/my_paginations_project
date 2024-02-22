package com.example.backend;

import com.example.backend.db.Db;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        Db.genData();
        SpringApplication.run(BackendApplication.class, args);
    }

}
