package com.example.beckend.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
   private Integer id;
   public static  int lastId;
    private String last;
    private String first;
    private Integer age;
    private String img;
}
