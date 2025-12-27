package com.examly.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserServiceInterface {
    @Autowired
    private UserRepository repo;
    
    public User AddUser(User user){
        return repo.save(user);
    }
    
    public User updateUser(Long id, User user){
        user.setId(id);
        return repo.save(user);
    }
     
    public List<User> GetAllUsers(){
        return repo.findAll();
    }

    public User getUserById(Long id){
        return repo.findById(id).orElse(null);
    }
    
    public void deleteUser(Long id){
        repo.deleteById(id);
    }
    
    public Page<User> getUsersWithPagination(Pageable pageable) {
        return repo.findAll(pageable);
    }
    
    public List<User> getUsersByRole(String role) {
        return repo.findByRole(role);
    }
}
