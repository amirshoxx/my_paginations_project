package com.example.back.controller;

import com.example.back.dto.UserDto;
import com.example.back.entity.User;
import com.example.back.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
@RequiredArgsConstructor
public class UserController {
    final UserRepo userRepo;

    @GetMapping
    public Page<User> getUsers(@RequestParam Integer page){
        Pageable pageable = PageRequest.of(page-1,3);
        Page<User> all = userRepo.findAll(pageable);
        return all;
    }

    @PostMapping
    public void addUsers(@RequestBody UserDto userDto){
        User build = User.builder()
                .name(userDto.name())
                .build();
        userRepo.save(build);
    }
}
