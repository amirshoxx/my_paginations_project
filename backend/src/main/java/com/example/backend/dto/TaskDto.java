package com.example.backend.dto;

import com.example.backend.enums.Status;

public record TaskDto(
        String title,
        Status status
) {
}
