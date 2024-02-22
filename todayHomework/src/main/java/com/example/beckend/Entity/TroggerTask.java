package com.example.beckend.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TroggerTask {
    private Integer id;
    private String name;
    private String status;
}
