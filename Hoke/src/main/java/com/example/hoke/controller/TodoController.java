package com.example.hoke.controller;


import com.example.hoke.db.Db;
import com.example.hoke.dto.TodoDto;
import com.example.hoke.entity.Todo;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.List;
import java.util.UUID;

@RequestMapping("/todos")
@RestController
@CrossOrigin()
public class TodoController {


    @GetMapping
    public List<Todo> getTodo(){
        return Db.todos;
    }

    @PostMapping
    public Todo saveTodo(@RequestBody TodoDto dto){
        Todo todo = new Todo(
                UUID.randomUUID(),
                dto.name(),
                dto.description(),
                dto.status()
        );
       Db.todos.add(todo);
       return todo;
    }

    @DeleteMapping()
    public String  deleteTodo(@RequestParam UUID id){
        for (Todo todo : Db.todos) {
            todo.getId().equals(id);
            Db.todos.remove(todo);
        }
     return "DELETED";
    }
}
