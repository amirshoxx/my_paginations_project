package com.example.amirsjpatask.repository;

import com.example.amirsjpatask.entity.Category;
import com.example.amirsjpatask.projection.CategoryProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category,Long> {
    List<CategoryProjection> findAllBy();

    List<Category> findByNameContainingIgnoreCase(String name);
}
