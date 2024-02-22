package com.example.back.config;

import com.example.back.entity.User;
import com.example.back.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {
    @Autowired
    UserRepo userRepo;

    @Override
    public void run(String... args) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User[]> response = restTemplate.getForEntity(
                "http://jsonplaceholder.typicode.com/users",
                User[].class
        );
        User[] users = response.getBody();
        assert users != null;
        userRepo.saveAll(Arrays.stream(users).toList());
    }
}
