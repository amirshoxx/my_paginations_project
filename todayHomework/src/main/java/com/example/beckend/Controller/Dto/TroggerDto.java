package com.example.beckend.Controller.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TroggerDto {
    private Integer id;
    private String name;
    private String status;
}
