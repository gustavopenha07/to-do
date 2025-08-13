package com.api.todo.dto;

public record TaskRequestDTO(
    String title,
    String description,
    String startAt,
    String endAt,
    boolean completed

) {
    
}
