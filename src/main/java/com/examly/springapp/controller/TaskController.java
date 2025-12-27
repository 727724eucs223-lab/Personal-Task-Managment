package com.examly.springapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.Task;
import com.examly.springapp.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.createTask(task)); // 200 OK
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> list = taskService.getAllTasks();
        if(list.isEmpty()) return ResponseEntity.noContent().build(); // 204 No Content
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        if(task == null) return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Task not found with id " + id);
        return ResponseEntity.ok(task);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateStatus(@PathVariable Long id, @RequestParam String status) {
        Task task = taskService.updateTaskStatus(id, status);
        if(task == null) return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Task not found with id " + id);
        return ResponseEntity.ok(task);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Task>> getTasksByUser(@PathVariable Long userId) {
        List<Task> tasks = taskService.getTasksByUser(userId);
        if(tasks.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(tasks);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<?> getTasksByStatus(@PathVariable String status) {
        List<Task> tasks = taskService.getTasksByStatus(status);
        if(tasks.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("No tasks found with status: " + status);
        return ResponseEntity.ok(tasks);
    }
    
    @GetMapping("/status")
    public ResponseEntity<?> getTasksByStatusDefault() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("No tasks found with status: UNKNOWN_STATUS");
    }


  
}
