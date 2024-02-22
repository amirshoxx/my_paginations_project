package com.example.shop.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private UUID id;
    @NotNull
    private String fullName;
    @NotBlank
    private String password;
    private Integer age;
    @NotNull
    private String email;
    @NotBlank
    private String phoneNumber;
    private Role role;

    public boolean userAuth(String email, String password){
        return this.email.equals(email)&&this.password.equals(password);
    }

}
