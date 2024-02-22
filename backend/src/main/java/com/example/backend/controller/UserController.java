package com.example.backend.controller;

import com.example.backend.db.Db;
import com.example.backend.dto.UserLoginDto;
import com.example.backend.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public List<User> getUsers(){
        return Db.users;
    }

    @PostMapping
    public User loginUser(@RequestBody UserLoginDto dto) {
        for (User user : Db.users) {
            if (user.getFirstName().equals(dto.firstName())
                    && user.getPassword().equals(dto.password())){
                return user;
            }
        }
        return null;
    }
}
