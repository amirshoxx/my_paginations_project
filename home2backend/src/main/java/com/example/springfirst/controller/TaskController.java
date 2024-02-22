package com.example.springfirst.controller;

import com.example.springfirst.DB.DB;
import com.example.springfirst.entity.*;
import com.example.springfirst.payload.TaskReq;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/task")
public class TaskController {
    @PostMapping
    public void postTask(@RequestBody TaskReq taskReq) {
        DB.tasks.add(new Task(UUID.randomUUID(), taskReq.getTitle(), taskReq.getDesc(), TaskStatus.OPEN));
    }

    @PostMapping("/assign")
    public void postTaskUser(@RequestBody List<User> user, @RequestParam String taskId) {
        for (UserTask taskUser : DB.taskUsers) {
            if (taskUser.getTaskId().equals(taskId)) {
                for (User user1 : user) {
                    if (user1.getWorkType().equals("BACKEND")) {
                        user1.setWorkType(WorkType.BACKEND);
                    } else if (user1.getWorkType().equals("FRONTEND")) {
                        user1.setWorkType(WorkType.FRONTEND);
                    } else if (user1.getWorkType().equals("TEST")) {
                        user1.setWorkType(WorkType.TEST);
                    }
                }
                taskUser.setUsers(user);
            }
        }
        DB.taskUsers.add(new UserTask(UUID.randomUUID(), user, taskId));
    }

    @GetMapping
    public ArrayList<Task> getTask() {
        return DB.tasks;
    }



    @DeleteMapping
    public String delObj(@RequestParam UUID id) {
        for (Task task : DB.tasks) {
            if (task.getId().equals(id)) {
                DB.tasks.remove(task);
            }
        }
        return "UCHDI";
    }


    @PutMapping()
    public void putRole(@RequestParam String id) {
        for (Task task : DB.tasks) {
            if (task.getId().toString().equals(id)) {
                if (task.getStatus().equals(TaskStatus.OPEN)) {
                    task.setStatus(TaskStatus.INPROGRESS);
                    break;
                }
                if (task.getStatus().equals(TaskStatus.INPROGRESS)) {
                    task.setStatus(TaskStatus.TESTING);
                    break;
                }
                if (task.getStatus().equals(TaskStatus.TESTING)) {
                    task.setStatus(TaskStatus.COMPLETE);
                    break;
                }
                if (task.getStatus().equals(TaskStatus.COMPLETE)) {
                    task.setStatus(TaskStatus.ARCHIVE);
                    break;
                }
            }
        }
    }
}
