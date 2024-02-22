package com.example.lessonjdbs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;
    private String description;
    private String product_type;
    private String brand_name;
    private Integer coast_price;
}
