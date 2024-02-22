package com.example.jpa_project.controller;

import com.example.jpa_project.dto.TodoDto;
import com.example.jpa_project.entity.Todo;
import com.example.jpa_project.repo.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class TodoController {
   @Autowired
    TodoRepo todoRepo;
    @GetMapping
    public ResponseEntity<?>getStudent(){
        List<Todo> all = todoRepo.findAll();
        return ResponseEntity.ok(all);
    }



    @DeleteMapping
    public ResponseEntity<?> postStudent(@RequestBody TodoDto dto){
       todoRepo.deleteAllByIdIn(dto.getIds());
        return ResponseEntity.ok("Deleted");
    };




}
