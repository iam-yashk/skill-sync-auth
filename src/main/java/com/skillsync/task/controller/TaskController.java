package com.skillsync.task.controller;

import com.skillsync.task.model.Task;
import com.skillsync.task.repository.TaskRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/tasks")
@RestController
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task created = taskRepository.save(task);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTask() {
        List<Task> allTasks = taskRepository.findAll();
        return ResponseEntity.ok(allTasks);
    }

}
