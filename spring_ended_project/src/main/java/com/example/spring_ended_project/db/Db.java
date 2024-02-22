package com.example.spring_ended_project.db;

import com.example.spring_ended_project.entity.Course;
import com.example.spring_ended_project.entity.Lesson;
import com.example.spring_ended_project.entity.Modul;
import com.example.spring_ended_project.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Db {

    public static List<User> users = new ArrayList<>();
    public static List<Course> courses = new ArrayList<>();
    public static List<Modul> moduls = new ArrayList<>();
    public static List<Lesson> lessons = new ArrayList<>();

    public static void init(){

        users.addAll(List.of(new User(
                UUID.randomUUID(),
                "amir@gmail.com",
                "123"
        )));
    }



}
