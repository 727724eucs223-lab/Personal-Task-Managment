package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Comment;
import com.examly.springapp.repository.CommentRepository;

@Service
public class CommentService {
    @Autowired
    private CommentRepository repo;
    public Comment updateComment(Long id,Comment comment){
        return repo.save(comment);
    }
}
