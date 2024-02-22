package com.example.spring_ended_project.controller;

import com.example.spring_ended_project.db.Db;
import com.example.spring_ended_project.dto.LessonDto;
import com.example.spring_ended_project.entity.Lesson;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RestController
@CrossOrigin
@RequestMapping("/lesson")
public class LessonController {
    @GetMapping("/{modulId}")
    public List<Lesson> getLessons(@PathVariable UUID modulId){
        List<Lesson> lessons = new ArrayList<>();
        for (Lesson lesson : Db.lessons) {
            if(lesson.getModuleId().equals(modulId)){
                lessons.add(lesson);
            }
        }
        return lessons;
    }

    @PostMapping("/{modulId}")
    public void postLesson(@RequestBody LessonDto lessonDto, @PathVariable UUID modulId){
        for (Lesson lesson : Db.lessons) {
            if(lesson.getTitle().equals(lessonDto.getTitle())){
                return;
            }
        }
        Db.lessons.add(new Lesson(UUID.randomUUID(), lessonDto.getTitle(), lessonDto.getDesc(),modulId));
    }

    @DeleteMapping("/{lessonId}")
    public void deleteLesson(@PathVariable UUID lessonId){
        for (Lesson lesson : Db.lessons) {
            if(lesson.getId().equals(lessonId)){
                Db.lessons.remove(lesson);
                break;
            }
        }
    }
}
