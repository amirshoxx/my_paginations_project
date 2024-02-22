package com.example.amirsjpatask.controller;

import com.example.amirsjpatask.dto.CategoryDto;
import com.example.amirsjpatask.entity.Category;
import com.example.amirsjpatask.projection.CategoryProjection;
import com.example.amirsjpatask.repository.CategoryRepo;
import com.example.amirsjpatask.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    TaskRepo taskRepo;
    @GetMapping
    public ResponseEntity<?> getCategory(){
        List<CategoryProjection> categories = categoryRepo.findAllBy();
        return ResponseEntity.ok(categories);
    }
    @PostMapping
    public ResponseEntity<?> saveCategory(@RequestBody CategoryDto categoryDto){
        Category save = categoryRepo.save(new Category(categoryDto.getName()));
        return ResponseEntity.ok(save);
    }
    @GetMapping("/search/{name}")
    public ResponseEntity<?> getCategoryByName(@PathVariable String name) {
        List<Category> categories = categoryRepo.findByNameContainingIgnoreCase(name);
        return ResponseEntity.ok(categories);
    }

}
