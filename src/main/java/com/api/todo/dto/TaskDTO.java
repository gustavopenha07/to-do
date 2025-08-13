package com.api.todo.dto;

import java.time.LocalDateTime;

import com.api.todo.model.Task;

public record TaskDTO(String title, String description, LocalDateTime startAt, LocalDateTime endAt, boolean completed) {
    public TaskDTO(Task task) {
    this(
        task.getTitle(),
        task.getDescription(),
        task.getStartAt(),
        task.getEndAt(),
        task.isCompleted()
    );
}

}
