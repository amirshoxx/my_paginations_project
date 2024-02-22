package com.example.shop.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Korzinka {
    private UUID id;
    private LocalDateTime localDateTime;
    private UUID userId;
    private List<Product> products;
}
