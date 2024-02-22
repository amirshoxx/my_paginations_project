package com.example.amirsjpatask.projection;

import java.util.Date;

public interface TaskProjection {
    Long getId();

    String getName();

    Date getDate();

    Boolean getActive();
    String getPreority();

    String getCategoryName();
}
