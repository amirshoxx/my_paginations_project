package com.example.chat_app_project.projection;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.util.UUID;

public interface MessageProjection {
    UUID getId();
    String getText();
    LocalDateTime getCreatedAt();
    @Value("#{target.fullName}")
    String getFullName();

    UUID getFromUserId();
}
