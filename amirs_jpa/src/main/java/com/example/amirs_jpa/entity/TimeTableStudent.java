package com.example.amirs_jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TimeTableStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer paid;
    @ManyToOne
    private Student student;
    @ManyToOne
    private TimeTable timeTable;

    public TimeTableStudent(Integer paid, Student student, TimeTable timeTable) {
        this.paid = paid;
        this.student = student;
        this.timeTable = timeTable;
    }
}
