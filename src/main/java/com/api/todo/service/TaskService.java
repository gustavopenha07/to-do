package com.api.todo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.todo.dto.TaskRequestDTO;
import com.api.todo.model.Task;
import com.api.todo.model.User;
import com.api.todo.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;


    public List<Task> getTasksForUser(User user) {
        return taskRepository.findByUserId(user.getId());
    }

    public Task createTask(TaskRequestDTO request, User user) {
        Task task = new Task();
        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setStartAt(LocalDateTime.parse(request.startAt()));
        task.setEndAt(LocalDateTime.parse(request.endAt()));
        task.setUser(user);

        return taskRepository.save(task);
    }

    public Task updateTask(Long taskId, TaskRequestDTO request, User user) {
        Task task = taskRepository.findById(taskId)
            .orElseThrow(() -> new RuntimeException("Task not found"));

        if (!task.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("User not authorized");
        }

        if (request.title() != null) {
            task.setTitle(request.title());
        }
        if (request.description() != null) {
            task.setDescription(request.description());
        }
        if (request.startAt() != null) {
            task.setStartAt(LocalDateTime.parse(request.startAt()));
        }
        if (request.endAt() != null) {
            task.setEndAt(LocalDateTime.parse(request.endAt()));
        }

        return taskRepository.save(task);
    }

    public void deleteTask(Long taskId, User user) {
        Task task = taskRepository.findById(taskId)
            .orElseThrow(() -> new RuntimeException("Task not found"));

        if (!task.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("User not authorized");
        }

        taskRepository.delete(task);
    }

}
