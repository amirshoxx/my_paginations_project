package com.example.spring_ended_project.controller;


import com.example.spring_ended_project.db.Db;
import com.example.spring_ended_project.dto.CourseDto;
import com.example.spring_ended_project.entity.Course;
import com.example.spring_ended_project.entity.Modul;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/courses")
public class CourseController {
    @GetMapping
    public List<Course> getCourses()    {
        return Db.courses;
    }

    @PostMapping
    public void postCourse(@RequestBody CourseDto courseDto){
        System.out.println(courseDto);
        for (Course cours : Db.courses) {
            if (cours.getTitle().equals(courseDto.getTitle())){
                return;
            }
        }
        Db.courses.add(new Course(UUID.randomUUID(),courseDto.getTitle(),courseDto.getDesc()));
    }

    @DeleteMapping("/{courseId}")
    public void deleteCourse(@PathVariable UUID courseId){
        for (Course cours : Db.courses) {
            if(cours.getId().equals(courseId)){
                Db.courses.remove(cours);
                break;
            }
        }
        for (Modul modul : Db.moduls) {
            if(modul.getCourseId().equals(courseId)){
                Db.moduls.remove(modul);
                break;
            }
        }
    }
}
