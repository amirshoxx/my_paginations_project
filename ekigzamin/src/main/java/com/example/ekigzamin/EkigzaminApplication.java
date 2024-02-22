package com.example.ekigzamin;

import com.example.ekigzamin.db.Db;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EkigzaminApplication {
    public static void main(String[] args) {
        SpringApplication.run(EkigzaminApplication.class, args);
        Db.init();
    }

}
