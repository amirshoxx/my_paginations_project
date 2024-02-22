package com.example.beckend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class BeckendApplication {

    public static void main(String[] args) throws IOException {
Db.getUser();
        SpringApplication.run(BeckendApplication.class, args);

    }
}

