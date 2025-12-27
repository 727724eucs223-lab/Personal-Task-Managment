package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Comment;
import com.examly.springapp.service.CommentService;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService service;
    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id,@RequestBody Comment comment){
        return new ResponseEntity<>(service.updateComment(id,comment),HttpStatus.OK);
    }
}
