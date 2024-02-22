package com.example.lessonjdbs.dto;

import lombok.Getter;

@Getter
public class InvoiceDto {
    private Long user_id;
    private Long product_id;
    private Integer sale_price;
    private Integer quantity;
}
