package com.example.jpa_project.repo;

import com.example.jpa_project.entity.Todo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TodoRepo extends JpaRepository<Todo,Long> {

@Transactional
    void deleteAllByIdIn(List<Long> ids);
}
