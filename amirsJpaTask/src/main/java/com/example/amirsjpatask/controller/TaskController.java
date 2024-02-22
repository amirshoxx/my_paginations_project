package com.example.amirsjpatask.controller;

import com.example.amirsjpatask.dto.IdsDto;
import com.example.amirsjpatask.dto.TaskDto;
import com.example.amirsjpatask.entity.Category;
import com.example.amirsjpatask.entity.Task;
import com.example.amirsjpatask.projection.TaskProjection;
import com.example.amirsjpatask.repository.CategoryRepo;
import com.example.amirsjpatask.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/task")
@CrossOrigin
public class TaskController {
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    TaskRepo taskRepo;
    @GetMapping("/")
    public ResponseEntity<?> getCategory(){
        List<TaskProjection> allBy = taskRepo.findAllBy();
        return ResponseEntity.ok(allBy);

    }
    @PostMapping
    public ResponseEntity<?> saveTask(@RequestBody TaskDto taskDto){
        Task save = taskRepo.save(new Task(taskDto.getName(), LocalDateTime.now(), taskDto.getActive(), taskDto.getPreority(), new Category(taskDto.getCategoryId(), null)));
        return ResponseEntity.ok(save);

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> editTask(@PathVariable Long id, @RequestBody TaskDto taskDto){
        Task save = taskRepo.save(new Task(id,taskDto.getName(), LocalDateTime.now(), taskDto.getActive(), taskDto.getPreority(), new Category(taskDto.getCategoryId(), null)));
        return ResponseEntity.ok(save);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<?>editTaskActive(@PathVariable Long id){
        Task taskById = taskRepo.getTaskById(id);
        taskById.setActive(!taskById.getActive());
        Task save = taskRepo.save(taskById);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<?> getTimeTableByCategoryId(@PathVariable Long categoryId) {
        List<TaskProjection> tasks = taskRepo.findAllByCategoryId(categoryId);
        return ResponseEntity.ok(tasks);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?> deleteTaskById(@PathVariable Long id){
        taskRepo.deleteById(id);
        return ResponseEntity.ok("deleted");
    }


    @DeleteMapping("/active")
    public ResponseEntity<?> deleteActiveTasks() {
        List<Task> activeTasks = taskRepo.findByActive(true);
        taskRepo.deleteAll(activeTasks);
        return ResponseEntity.ok("All active tasks have been deleted successfully.");
    }

}
