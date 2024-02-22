package com.example.beckend.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tasks {
    private Integer id;
    private String name ;
    private String status;
    private String type;
    private String createdAt;
    private Integer userId;


}
