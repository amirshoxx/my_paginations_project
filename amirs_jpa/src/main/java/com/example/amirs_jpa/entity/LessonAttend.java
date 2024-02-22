package com.example.amirs_jpa.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class LessonAttend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer mark;
    private Boolean active;
    @ManyToOne
    private TimeTableStudent timeTableStudent;
    @ManyToOne
    private Lesson lesson;

    public LessonAttend(Integer mark, Boolean active, TimeTableStudent timeTableStudent, Lesson lesson) {
        this.mark = mark;
        this.active = active;
        this.timeTableStudent = timeTableStudent;
        this.lesson = lesson;
    }
}
