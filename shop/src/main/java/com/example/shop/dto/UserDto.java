package com.example.shop.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDto {
    private String fullName;
    private String password;
    private Integer age;
    private String email;
    private String phoneNumber;
    private UUID token;
}
