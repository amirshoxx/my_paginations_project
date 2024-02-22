package com.example.projectlibrary.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class OrderDto {
    private Integer userId;
    private List<Integer> booksIds;

}
