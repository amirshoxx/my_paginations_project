package com.example.shop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
public class ProductDto {
    private UUID categoryId;
    private Double price;
    private String name;
}
