package com.example.beckend.FrontData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFront {
    private int id;
    private String full_name;
    private String img;
}
