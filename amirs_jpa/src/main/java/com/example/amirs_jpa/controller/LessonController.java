package com.example.amirs_jpa.controller;

import com.example.amirs_jpa.entity.Lesson;
import com.example.amirs_jpa.repo.LessonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lessons")
@CrossOrigin
public class LessonController {

    @Autowired
    LessonRepo lessonRepo;


    @GetMapping
    public ResponseEntity<?> getLessons(){
        List<Lesson> all = lessonRepo.findAll();
        return ResponseEntity.ok(all);
    }



}
