package com.example.beckend.projection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskFront {
    private Integer id;
    private String name;
    private String status;
    private String type;
    private String createdAt;
    private Integer userId;

    private String countryCode;
    private String city;
    private String firstName;
    private String img;
    private Integer adressId;

}

