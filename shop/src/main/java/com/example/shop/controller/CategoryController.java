package com.example.shop.controller;

import com.example.shop.db.Db;
import com.example.shop.dto.CategoryDto;
import com.example.shop.entity.Category;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/category")
public class CategoryController {
    @GetMapping
    public List<Category> getCategories(){
        return Db.categories;
    }
    @PostMapping
    public String addCategory(@RequestBody CategoryDto categoryDto){
        Category category = new Category(
                UUID.randomUUID(),
                categoryDto.getName()
        );
        Db.categories.add(category);
        return "Add Category";
    }
}
