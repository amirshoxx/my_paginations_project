package com.example.shop.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class OrderProductDto {
    private UUID userId;
    private UUID productId;
}
