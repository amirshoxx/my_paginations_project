package com.example.lessonjdbs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    private Long id;
    private Long user_id;
    private Long product_id;
    private Integer sale_price;
    private Integer quantity;
}
