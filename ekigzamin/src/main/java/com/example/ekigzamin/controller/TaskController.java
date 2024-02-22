package com.example.ekigzamin.controller;


import com.example.ekigzamin.db.Db;
import com.example.ekigzamin.dto.TaskDto;
import com.example.ekigzamin.entity.Category;
import com.example.ekigzamin.entity.Task;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/task")
public class TaskController {
    @GetMapping
    public List<Task> getTask(@RequestParam(defaultValue = "") UUID taskId){
        List<Task> tasks = new ArrayList<>();
        for (Task task : Db.tasks) {
            if (task.getCategoryId().equals(taskId)){
                tasks.add(task);
            }
        }
        return tasks;
    }


    @DeleteMapping
    public String deleteTask(@RequestParam(defaultValue = "" ) UUID id){
        for (Task task : Db.tasks) {
            if (task.getId().equals(id)){
                Db.tasks.remove(task);
            }
        }
        return "Deleted Task";
    }
    @PostMapping
    public String addTask(@RequestBody TaskDto taskDto,@RequestParam(defaultValue = "")UUID categoryId){
        Task task = new Task(
                UUID.randomUUID(),
                taskDto.getName(),
                LocalDateTime.now(),
                taskDto.getPriority(),
                categoryId,
                false
        );
        for (Category category : Db.categories) {
            if(category.getId().equals(categoryId)){
                Db.tasks.add(task);
            }

        }
        return "Add Task";
    }

    @PutMapping()
    public String putTask(@RequestParam UUID id){
        for (Task task : Db.tasks) {
            if (task.getId().equals(id)) {
   task.setCompleted(!task.isCompleted());
            }
        }
        return "PUT TASKS";
    }



}
