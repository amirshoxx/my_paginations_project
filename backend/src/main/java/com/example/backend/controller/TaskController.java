package com.example.backend.controller;

import com.example.backend.db.Db;
import com.example.backend.dto.TaskDto;
import com.example.backend.entity.Task;
import com.example.backend.enums.Status;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/task")
public class TaskController {
    @GetMapping("/all")
    public List<Task> getAllTask() {
        return Db.tasks;
    }

    @GetMapping
    public List<Task> getTasksStatus(@RequestParam Status status) {
        return Db.tasks.stream().filter(task -> task.getStatus().equals(status)).toList();
    }

    @PostMapping
    public String addTask(@RequestBody TaskDto dto) {
        if (dto.title() != null && dto.status() != null) {
            Db.tasks.add(new Task(dto.title(), dto.status()));
            return "Task is added";
        } else {
            return "Task is not added";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteTaskById(@PathVariable Integer id) {
        if (Db.tasks.removeIf(task -> task.getId().equals(id))) {
            return id + "-task is deleted";
        } else {
            return id + "-task is not deleted";
        }
    }
}
