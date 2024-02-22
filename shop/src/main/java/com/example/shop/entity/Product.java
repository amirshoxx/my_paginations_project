package com.example.shop.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @NotBlank
    private UUID id;
    private UUID categoryId;
    @NotBlank
    private Double price;
    @NotNull
    private String name;
}
