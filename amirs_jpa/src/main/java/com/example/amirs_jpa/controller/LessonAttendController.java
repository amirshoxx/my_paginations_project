package com.example.amirs_jpa.controller;


import com.example.amirs_jpa.dto.LessonAttendDto;
import com.example.amirs_jpa.dto.TimeTableStudentDto;
import com.example.amirs_jpa.entity.*;
import com.example.amirs_jpa.projection.TimeTableStudents;
import com.example.amirs_jpa.projection.TimeTableStudentsLesson;
import com.example.amirs_jpa.repo.LessonAttendRepo;
import com.example.amirs_jpa.repo.LessonRepo;
import com.example.amirs_jpa.repo.TimeTableStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lesson")
@CrossOrigin
public class LessonAttendController {
    @Autowired
    LessonRepo lessonRepo;

    @Autowired
    LessonAttendRepo lessonAttendRepo;

    @Autowired
    TimeTableStudentRepo timeTableStudentRepo;



    @GetMapping("/{timeTableStudentId}")
    public ResponseEntity<?> getTimeTableStudentLesson(@PathVariable Long timeTableStudentId){
        List<LessonAttend> allByTimeTableStudentId = lessonAttendRepo.getAllByTimeTableStudentId(timeTableStudentId);
        List<TimeTableStudentsLesson> timeTableStudentsLessons = new ArrayList<>();
        for (LessonAttend lessonAttend : allByTimeTableStudentId) {
            Lesson lesson = lessonAttend.getLesson();
            Optional<Lesson> byId = lessonRepo.findById(lesson.getId());
            TimeTableStudentsLesson timeTableStudentsLesson1 = new TimeTableStudentsLesson(lesson.getId(), byId.get().getTitle(), byId.get().getDescription(), lessonAttend.getMark(), lessonAttend.getActive());
            timeTableStudentsLessons.add(timeTableStudentsLesson1);
        }
        return ResponseEntity.ok(timeTableStudentsLessons);
    }



    @PostMapping
    public ResponseEntity<?>saveLesson(@RequestBody LessonAttendDto dto){
        Lesson lessonById = lessonRepo.getLessonById(dto.getLessonId());
        TimeTableStudent timeTableStudentById = timeTableStudentRepo.getTimeTableStudentById(dto.getTimeTableStudentId());
        LessonAttend lessonAttend = new LessonAttend(dto.getMark(), dto.getActive(),timeTableStudentById, lessonById);
        System.out.println(lessonAttend.getTimeTableStudent());
        LessonAttend save = lessonAttendRepo.save(lessonAttend);
        return ResponseEntity.ok(save);
    }
}
