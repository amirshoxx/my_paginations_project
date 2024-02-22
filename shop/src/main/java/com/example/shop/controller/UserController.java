package com.example.shop.controller;

import com.example.shop.db.Db;
import com.example.shop.dto.UserDto;
import com.example.shop.entity.Role;
import com.example.shop.entity.User;
import com.example.shop.repository.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class UserController {
    @GetMapping("/me")
    public ApiResponse getOneUser(@RequestHeader(defaultValue = "") String token){
        for (User user : Db.users) {
            if (user.getId().toString().equals(token)){
                return new ApiResponse(true, "",user.getRole());
            }
        }
        return new ApiResponse(false, "Token xato",null);
    }


    @PostMapping("/auth")
    public ApiResponse auth(@RequestBody UserDto dto){
        for (User user : Db.users) {
     if(user.userAuth(dto.getEmail(), dto.getPassword())){
            return new ApiResponse(
                    true,
                    "Login qilindi",
                    user.getId()
            );
            }
        }
        return new ApiResponse(
                false,
                "Login qilimadi",
              null
        );
    }


    @PostMapping("/register")
    public List<User> addUser(@RequestBody UserDto userDto){
        List<User> users = new ArrayList<>();
        if (findUserByUserEmail(userDto)){
            for (User user : Db.users) {
                if (user.userAuth(userDto.getEmail(),userDto.getPassword())){
                    users.add(user);
                    break;
                }
            }
        }else {
            User user =new User(
                    UUID.randomUUID(),
                    userDto.getFullName(),
                    userDto.getPassword(),
                    userDto.getAge(),
                    userDto.getEmail(),
                    userDto.getPhoneNumber(),
                    Role.ROLE_USER
            );
            Db.users.add(user);
            users.add(user);
        }
        return users;

    }

    @GetMapping
    public ApiResponse getAllUsers(){
        return new ApiResponse(true,null,Db.users);
    }
    @GetMapping("/users")

    public List<User> getUsers(){
        return Db.users;
    }

    private boolean findUserByUserEmail(UserDto userDto) {
        for (User user : Db.users) {
            if (user.getEmail().equals(userDto.getEmail())){
                return true;
            }
        }
        return false;
    }

}
