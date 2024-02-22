package com.example.spring_ended_project.controller;

import com.example.spring_ended_project.db.Db;
import com.example.spring_ended_project.dto.ModulDto;
import com.example.spring_ended_project.entity.Lesson;
import com.example.spring_ended_project.entity.Modul;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RestController
@CrossOrigin
@RequestMapping("/module")
public class ModuleController {
    @GetMapping("/{courseId}")
    public List<Modul> getModuls(@PathVariable UUID courseId){
        List<Modul> moduls = new ArrayList<>();
        for (Modul modul : Db.moduls) {
            if(modul.getCourseId().equals(courseId)){
                moduls.add(modul);
            }
        }
        return moduls;
    }

    @PostMapping("/{courseId}")
    public void postModul(@RequestBody ModulDto modulDto, @PathVariable UUID courseId){
        for (Modul modul : Db.moduls) {
            if(modul.getTitle().equals(modulDto.getTitle())){
                return;
            }
        }
        Db.moduls.add(new Modul(UUID.randomUUID(), modulDto.getTitle(),modulDto.getDesc(),courseId));
    }

    @DeleteMapping("/{modulId}")
    public void deleteModul(@PathVariable UUID modulId){
        for (Modul modul : Db.moduls) {
            if(modul.getId().equals(modulId)){
                Db.moduls.remove(modul);
                break;
            }
        }
        for (Lesson lesson : Db.lessons) {
            if(lesson.getModuleId().equals(modulId)){
                Db.lessons.remove(lesson);
                break;
            }
        }
    }

}
