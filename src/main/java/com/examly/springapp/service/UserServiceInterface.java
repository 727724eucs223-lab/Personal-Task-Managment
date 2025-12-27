package com.examly.springapp.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.examly.springapp.model.User;

public interface UserServiceInterface {
    User AddUser(User user);
    User updateUser(Long id, User user);
    List<User> GetAllUsers();
    User getUserById(Long id);
    void deleteUser(Long id);
    Page<User> getUsersWithPagination(Pageable pageable);
    List<User> getUsersByRole(String role);
}