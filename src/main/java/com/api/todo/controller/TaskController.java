package com.api.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.todo.dto.TaskRequestDTO;
import com.api.todo.error.UserNotFoundException;
import com.api.todo.dto.TaskDTO;
import com.api.todo.model.Task;
import com.api.todo.model.User;
import com.api.todo.repository.UserRepository;
import com.api.todo.service.TaskService;

@RequestMapping("/task")
@RestController
public class TaskController {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskService taskService;


    private User getCurrentUser(Authentication auth) {
        return userRepository.findByUsername(auth.getName())
                             .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getTasks(Authentication auth) {
        User user = getCurrentUser(auth);
        List<Task> tasks = taskService.getTasksForUser(user);
        List<TaskDTO> taskDTOs = tasks.stream().map(TaskDTO::new).toList();
        return ResponseEntity.ok(taskDTOs);
    }  

    @PostMapping("/")
    public ResponseEntity<TaskDTO> create(@RequestBody TaskRequestDTO request, Authentication auth) {
        User user = getCurrentUser(auth);
        Task savedTask = taskService.createTask(request, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new TaskDTO(savedTask));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> update(@PathVariable Long id,
                                      @RequestBody TaskRequestDTO request,
                                      Authentication auth) {

        User user = getCurrentUser(auth);
        Task updatedTask = taskService.updateTask(id, request, user);
        return ResponseEntity.ok(new TaskDTO(updatedTask));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id, Authentication auth) {
        User user = getCurrentUser(auth);
        taskService.deleteTask(id, user);
        return ResponseEntity.ok().build();
    }
}
