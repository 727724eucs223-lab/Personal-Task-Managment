package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.TaskAssignment;

import com.examly.springapp.repository.TaskAssignmentRepository;

@Service
public class TaskAssignmentService {
    @Autowired
    private TaskAssignmentRepository repo;

        public List<TaskAssignment> GetAllUsers(){
        return repo.findAll();
    }

}
