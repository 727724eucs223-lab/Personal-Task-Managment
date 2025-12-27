package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.Task;

public interface TaskService {
    Task createTask(Task task);
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    Task updateTaskStatus(Long id, String status);
    List<Task> getTasksByUser(Long userId);
    void deleteTask(Long id);
    List<Task> getTasksByStatus(String status);
}
