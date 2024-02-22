package com.example.amirs_jpa.repo;

import com.example.amirs_jpa.entity.TimeTableStudent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TimeTableStudentRepo extends JpaRepository<TimeTableStudent,Long> {
List <TimeTableStudent>getAllByTimeTableId(Long timeTableId);

TimeTableStudent getTimeTableStudentById(Long timeTableStudentId);

}
