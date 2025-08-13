package com.api.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.todo.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUserId(Long userId);
    List<Task> findByUserIdAndCompleted(Long userId, boolean completed);
}
