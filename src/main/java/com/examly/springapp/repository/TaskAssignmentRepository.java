package com.examly.springapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.TaskAssignment;

@Repository
public interface TaskAssignmentRepository extends JpaRepository<TaskAssignment,Long>{
    @Query("SELECT ta FROM TaskAssignment ta WHERE ta.user.id = :userId")
    List<TaskAssignment> findByUserId(@Param("userId") Long userId);
}
