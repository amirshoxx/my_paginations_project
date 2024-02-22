package com.example.amirs_jpa.controller;

import com.example.amirs_jpa.dto.GroupDto;
import com.example.amirs_jpa.dto.StudentDto;
import com.example.amirs_jpa.entity.Group;
import com.example.amirs_jpa.entity.Student;
import com.example.amirs_jpa.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
    @Autowired
    StudentRepo studentRepo;

    @GetMapping
    public ResponseEntity<?> getAllGroups(){
        List<Student> all = studentRepo.findAll();
        return ResponseEntity.ok(all);
    }

    @PostMapping
    public ResponseEntity<?> saveGroup(@RequestBody StudentDto dto){
        Student student = new Student(dto.getFirstName(), dto.getAge());
        Student save = studentRepo.save(student);
        return ResponseEntity.ok(save);
    }
}
