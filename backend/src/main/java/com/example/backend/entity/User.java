package com.example.backend.entity;

import com.example.backend.enums.Role;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {
    private Integer id;
    private String firstName;
    private String password;
    private Role role;
    private static int lastId;

    public User(String firstName, String password, Role role) {
        this.id = ++lastId;
        this.firstName = firstName;
        this.password = password;
        this.role = role;
    }
}
