package com.examly.springapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.TaskStatusLog;
import com.examly.springapp.repository.TaskStatusLogRepository;

@RestController
@RequestMapping("/api/status-logs")
public class TaskStatusLogController {

    @Autowired
    private TaskStatusLogRepository repo;

    @PostMapping
    public ResponseEntity<TaskStatusLog> addStatusLog(@RequestBody TaskStatusLog log) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(log));
    }

    @GetMapping
    public ResponseEntity<List<TaskStatusLog>> getAllLogs() {
        List<TaskStatusLog> logs = repo.findAll();
        if (logs.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(logs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskStatusLog> getLogById(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity<List<TaskStatusLog>> getLogsByTask(@PathVariable Long taskId) {
        List<TaskStatusLog> logs = repo.findByTaskId(taskId);
        if (logs.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(logs);
    }

    @GetMapping("/old/{oldStatus}")
    public ResponseEntity<?> getLogsByOldStatus(@PathVariable String oldStatus) {
        List<TaskStatusLog> logs = repo.findByOldStatus(oldStatus);
        if (logs.isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("No logs found with oldStatus: " + oldStatus);
        return ResponseEntity.ok(logs);
    }
}
