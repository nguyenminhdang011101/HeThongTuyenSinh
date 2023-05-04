/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nmd.service.impl;

import com.nmd.pojo.Comment;
import com.nmd.repository.CommentRepository;
import com.nmd.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author admin
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepo;

    @Override
    public List<Comment> getComments() {
        return this.commentRepo.getComments();
    }

    @Override
    public Comment addComment(Comment c) {
        return this.commentRepo.addComment(c);
    }
    
}
