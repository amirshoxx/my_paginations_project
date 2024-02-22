package com.example.amirsjpatask.repository;

import com.example.amirsjpatask.entity.Category;
import com.example.amirsjpatask.entity.Task;
import com.example.amirsjpatask.projection.TaskProjection;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task,Long> {
    List<TaskProjection> findAllBy();
    List<TaskProjection> findAllByCategoryId(Long categoryId);

    Integer countAllByCategory(Category category);

    Task getTaskById(Long id);
    List<Task> findByActive(boolean b);
    @Transactional
    void deleteAllByIdIn(List<Long> ids);
}
