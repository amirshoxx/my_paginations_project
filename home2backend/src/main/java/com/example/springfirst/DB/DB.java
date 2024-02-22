package com.example.springfirst.DB;

import com.example.springfirst.entity.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DB {
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Task> tasks = new ArrayList<>();
    public static ArrayList<UserTask> taskUsers = new ArrayList<>();
    public static void generate(){
        User user = new User(
                UUID.randomUUID(),
                "Amir",
                21,
                false,
                "1"
        );


        taskUsers.add(new UserTask(UUID.randomUUID(),new ArrayList<User>(),""));


        users.addAll(List.of(user));

        Task task
                =new Task(
                        UUID.randomUUID(),
                "eeeeeee",
                "rreeedrrrrr",
                TaskStatus.OPEN

        );

        Task task1
                =new Task(
                UUID.randomUUID(),
                "eeeetrfeee",
                "rrrgdrrrrr",
                TaskStatus.OPEN

        ); Task task2
                =new Task(
                UUID.randomUUID(),
                "eeethgeeee",
                "rrrgrfvrrrr",
                TaskStatus.OPEN

        );
        tasks.addAll(List.of(task,task1,task2));
    }
}
