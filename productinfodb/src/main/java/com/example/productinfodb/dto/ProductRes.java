package com.example.productinfodb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRes {
    private Long id;
    private String name;
    private Integer price;
    private String text;
}
