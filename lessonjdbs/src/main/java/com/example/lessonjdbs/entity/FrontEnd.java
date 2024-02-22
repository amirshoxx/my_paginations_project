package com.example.lessonjdbs.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FrontEnd {
    private Long id;
    private Long product_id;
    private String description;
    private String product_type;
    private  String brand_name;
    private Integer quantity;
    private Integer coast_price;
    private Integer sale_price;
    private String name;
    private Integer phone;
}
