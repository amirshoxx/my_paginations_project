package com.example.amirs_jpa.controller;
import com.example.amirs_jpa.dto.TimeTableStudentDto;
import com.example.amirs_jpa.entity.Student;
import com.example.amirs_jpa.entity.TimeTable;
import com.example.amirs_jpa.entity.TimeTableStudent;
import com.example.amirs_jpa.projection.TimeTableStudents;
import com.example.amirs_jpa.repo.StudentRepo;
import com.example.amirs_jpa.repo.TimeTableRepo;
import com.example.amirs_jpa.repo.TimeTableStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/timetableStudent")
@CrossOrigin
public class TimeTableStudentController {


    @Autowired
    TimeTableStudentRepo timeTableStudentRepo;

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    TimeTableRepo timeTableRepo;


    @GetMapping
    public ResponseEntity<?> getAllTimeTable() {
        List<TimeTableStudent> all = timeTableStudentRepo.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{monthId}")
    public ResponseEntity<?> getAllStudents(@PathVariable Long monthId) {
        List<TimeTableStudent> allByTimeTableId = timeTableStudentRepo.getAllByTimeTableId(monthId);
      List<TimeTableStudents> timeTableStudents = new ArrayList<>();
        for (TimeTableStudent timeTableStudent : allByTimeTableId) {
            Student student = timeTableStudent.getStudent();
            Optional<Student> byId = studentRepo.findById(student.getId());
                TimeTableStudents timeTableStudents1 = new TimeTableStudents(timeTableStudent.getId(),
                        byId.get().getFirstName(),
                        byId.get().getAge(),
                        timeTableStudent.getPaid());
                timeTableStudents.add(timeTableStudents1);
        }
        return ResponseEntity.ok(timeTableStudents);
    }
    @PostMapping
    public ResponseEntity<?> saveTimeTable(@RequestBody TimeTableStudentDto dto) {
        Student studentById = studentRepo.getStudentById(dto.getStudentId());
        TimeTable timeTableById = timeTableRepo.getTimeTableById(dto.getTimeTableId());
        TimeTableStudent timeTableStudent = new TimeTableStudent(dto.getPaid(), studentById, timeTableById);
        TimeTableStudent save = timeTableStudentRepo.save(timeTableStudent);
        return ResponseEntity.ok(save);
    }

}
