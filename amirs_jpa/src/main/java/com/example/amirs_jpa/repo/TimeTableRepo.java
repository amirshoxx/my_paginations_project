package com.example.amirs_jpa.repo;

import com.example.amirs_jpa.entity.TimeTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TimeTableRepo extends JpaRepository<TimeTable,Long> {

   List<TimeTable> getAllByGroupId(Long groupId);

   TimeTable getTimeTableById(Long id);
}
