package com.example.springfirst.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private UUID id;
    private String name;
    private Integer age;
    private Boolean status;
    private WorkType workType;
    private String password;

    public User(UUID id, String name, Integer age, Boolean status, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.status = status;
        this.password = password;
    }


}
