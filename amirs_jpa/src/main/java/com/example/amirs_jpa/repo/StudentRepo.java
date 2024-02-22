package com.example.amirs_jpa.repo;

import com.example.amirs_jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student,Long> {

    Student getStudentById(Long id);

}
