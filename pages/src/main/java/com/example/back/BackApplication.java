package com.example.back;

import com.example.back.entity.User;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BackApplication {
    @SneakyThrows
    public static void main(String[] args){
        SpringApplication.run(BackApplication.class, args);
    }
}
