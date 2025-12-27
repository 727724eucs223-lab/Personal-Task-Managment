package com.examly.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.TaskStatusLog;

@Repository
public interface TaskStatusLogRepository extends JpaRepository<TaskStatusLog,Long>{
  List<TaskStatusLog> findByTaskId(Long taskId);
  List<TaskStatusLog> findByOldStatus(String oldStatus);
}
