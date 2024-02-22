package com.example.amirs_jpa.repo;

import com.example.amirs_jpa.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LessonRepo extends JpaRepository<Lesson,Long> {

    Lesson getLessonById(Long id);

}
