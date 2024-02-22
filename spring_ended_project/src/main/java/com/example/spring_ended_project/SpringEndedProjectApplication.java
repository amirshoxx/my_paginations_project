package com.example.spring_ended_project;


import com.example.spring_ended_project.db.Db;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringEndedProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringEndedProjectApplication.class, args);
        Db.init();
    }

}
