package com.example.shop;

import com.example.shop.db.Db;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopApplication {

    public static void main(String[] args) {
        Db.init();
        SpringApplication.run(ShopApplication.class, args);
    }

}
