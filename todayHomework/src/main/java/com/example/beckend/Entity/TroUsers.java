package com.example.beckend.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TroUsers {
    private Integer id;
    private String full_name;
    private String status;
}
