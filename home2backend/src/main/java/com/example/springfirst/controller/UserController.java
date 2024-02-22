package com.example.springfirst.controller;


import com.example.springfirst.DB.DB;
import com.example.springfirst.dto.UserDto;
import com.example.springfirst.entity.User;
import com.example.springfirst.entity.UserTask;
import com.example.springfirst.payload.ApiResponse;
import com.example.springfirst.payload.ReqUser;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @PostMapping()
    public void registerUser(@RequestBody UserDto userDto) {
        DB.users.add(new User(UUID.randomUUID(), userDto.getLastname(), userDto.getAge(),false,"123"));

    }
    @PostMapping("/auth")
    public HttpEntity<ApiResponse> loginUser(@RequestBody ReqUser reqUser){
        for (User user : DB.users) {
            if (user.getName().equals(reqUser.getName()) && user.getPassword().equals(reqUser.getPassword())){
              return ResponseEntity.ok(new ApiResponse(true,user,"success"));
            }
        }
        return ResponseEntity.ok(new ApiResponse(false," Unsuccessful"));
    }
    @GetMapping
    public HttpEntity<ApiResponse> getUser(){
        System.out.println(DB.users);
        return ResponseEntity.ok(new ApiResponse(true,DB.users,"user"));

    }



    @GetMapping("/task")
    public List<UserTask> getUsersTAsk(@RequestParam String taskId){
        List<UserTask> userTasks = new ArrayList<>();
        for (UserTask taskUser : DB.taskUsers) {
            if (taskUser.getTaskId().equals(taskId)){
               userTasks.add(taskUser);
            }
        }
        System.out.println(userTasks);
        return userTasks;

    }

}
