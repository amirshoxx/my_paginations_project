package com.example.amirs_jpa.repo;


import com.example.amirs_jpa.entity.LessonAttend;
import com.example.amirs_jpa.entity.TimeTableStudent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Objects;

public interface LessonAttendRepo  extends JpaRepository<LessonAttend,Long> {
   List<LessonAttend> getAllByTimeTableStudentId(Long timeTableStudentId);

}
