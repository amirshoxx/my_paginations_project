package com.example.spring_ended_project.controller;


import com.example.spring_ended_project.db.Db;
import com.example.spring_ended_project.dto.LoginDto;
import com.example.spring_ended_project.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @PostMapping
    public User loginUser(@RequestBody LoginDto loginDto){
        for (User user : Db.users) {
            if(user.getLogin().equals(loginDto.getLogin()) && user.getPassword().equals(loginDto.getPassword()) ){
                return user;
        }
        }
        return null;
    }


}
