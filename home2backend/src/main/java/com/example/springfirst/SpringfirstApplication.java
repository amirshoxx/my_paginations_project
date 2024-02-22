package com.example.springfirst;

import com.example.springfirst.DB.DB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringfirstApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringfirstApplication.class, args);
        DB.generate();
    }

}
