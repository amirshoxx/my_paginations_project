package com.example.shop.repository;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class OrderProductRepo {
    private UUID id;
    private String name;
    private Double price;
}
