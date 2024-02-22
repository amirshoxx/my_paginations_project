package com.example.chat_app_project.controller;


import com.example.chat_app_project.dto.UserDto;
import com.example.chat_app_project.entity.User;
import com.example.chat_app_project.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {




    @Autowired
    UserRepo userRepo;


    @GetMapping("/{fromId}")
    public ResponseEntity<List<User>> getAll(@PathVariable UUID fromId){
        List<User> users = userRepo.allUsers(fromId);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/login")
    public ResponseEntity<?> getUsers(@RequestParam String email,@RequestParam String password){
        User byEmailAndPassword = userRepo.getByEmailAndPassword(email,password);
      if(byEmailAndPassword!=null){
          return ResponseEntity.ok(byEmailAndPassword);
      }else {
          return ResponseEntity.ok(0);
      }
    }
    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody UserDto dto){
        User user = new User(dto.getFirstName(), dto.getLastName(), dto.getEmail(), dto.getPassword());
        User save = userRepo.save(user);
        return ResponseEntity.ok(save);
    }

}
