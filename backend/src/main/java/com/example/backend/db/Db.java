package com.example.backend.db;

import com.example.backend.entity.Task;
import com.example.backend.entity.User;
import com.example.backend.enums.Role;
import com.example.backend.enums.Status;

import java.util.ArrayList;
import java.util.List;

public class Db {
    public static List<User> users = new ArrayList<>();
    public static List<Task> tasks = new ArrayList<>();

    public static void genData(){
        genUsers();
        genTasks();
    }

    private static void genTasks() {
        tasks.add(new Task("title 1", Status.OPEN));
        tasks.add(new Task("title 2", Status.OPEN));
        tasks.add(new Task("title 3", Status.INPROGRESS));
        tasks.add(new Task("title 4", Status.INPROGRESS));
        tasks.add(new Task("title 5", Status.TESTING));
        tasks.add(new Task("title 6", Status.TESTING));
        tasks.add(new Task("title 7", Status.COMPLETED));
        tasks.add(new Task("title 8", Status.COMPLETED));
    }

    private static void genUsers() {
        users.add(new User("AMIR", "123", Role.ROLE_SUPER_ADMIN));
        users.add(new User("Amir", "123", Role.ROLE_ADMIN));
        users.add(new User("amir", "123", Role.ROLE_USER));
    }
}
