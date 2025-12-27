package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.TaskAssignment;
import com.examly.springapp.repository.TaskAssignmentRepository;

@RestController
@RequestMapping("/api/assignments")
public class TaskAssignmentController {
    @Autowired
    private TaskAssignmentRepository repo;
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getAssignmentsByUserId(@PathVariable Long userId){
        List<TaskAssignment> list = repo.findByUserId(userId);
        if(list.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("No assignments found for user id: " + userId);
        }
        return ResponseEntity.ok(list);
    }
}
