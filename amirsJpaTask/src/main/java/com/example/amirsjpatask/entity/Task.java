package com.example.amirsjpatask.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  name;
    private LocalDateTime date;
    private Boolean active;
    private String preority;
    @ManyToOne
    private Category category;


    public Task(String name, LocalDateTime date, Boolean active, String preority, Category category) {
        this.name = name;
        this.date = date;
        this.active = active;
        this.preority = preority;
        this.category = category;
    }

}
