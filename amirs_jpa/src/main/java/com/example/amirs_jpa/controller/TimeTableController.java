package com.example.amirs_jpa.controller;


import com.example.amirs_jpa.dto.TimeTableDto;
import com.example.amirs_jpa.entity.Group;
import com.example.amirs_jpa.entity.TimeTable;

import com.example.amirs_jpa.repo.GroupRepo;
import com.example.amirs_jpa.repo.TimeTableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/timetable")
@CrossOrigin
public class TimeTableController {
    @Autowired
    TimeTableRepo timeTableRepo;
    @Autowired
    GroupRepo groupRepo;

    @GetMapping
    public ResponseEntity<?> getAllTimeTable() {
        List<TimeTable> all = timeTableRepo.findAll();
        return ResponseEntity.ok(all);
    }


    @GetMapping("/{groupId}")
    public ResponseEntity<?> getTimeTAbleBygroupId(@PathVariable Long groupId){
        List<TimeTable> allById = timeTableRepo.getAllByGroupId(groupId);
        return ResponseEntity.ok(allById);
    }

    @PostMapping
    public ResponseEntity<?> saveTimeTable(@RequestBody TimeTableDto dto) {
        Group groupById = groupRepo.getGroupById(dto.getGroupId());
        TimeTable timeTable = new TimeTable(dto.getName(), dto.getPrice(),groupById);
        TimeTable save = timeTableRepo.save(timeTable);
        return ResponseEntity.ok(save);
    }

}
