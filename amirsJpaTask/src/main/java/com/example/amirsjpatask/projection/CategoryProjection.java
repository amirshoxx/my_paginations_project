package com.example.amirsjpatask.projection;

import org.springframework.beans.factory.annotation.Value;

public interface CategoryProjection {
    Long getId();
    String getName();
    @Value("#{@taskRepo.countAllByCategory(target)}")
    Integer getCount();
}
