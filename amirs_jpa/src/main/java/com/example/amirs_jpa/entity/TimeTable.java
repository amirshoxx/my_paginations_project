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
public class TimeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String name;
    private Integer price;
    @ManyToOne
    private Group group;

    public TimeTable(String name, Integer price, Group group) {
        this.name = name;
        this.price = price;
        this.group = group;
    }
}
