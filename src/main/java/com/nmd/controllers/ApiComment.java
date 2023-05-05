/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nmd.controllers;

import com.nmd.pojo.Comment;
import com.nmd.pojo.LivestreamDetail;
import com.nmd.pojo.User;
import com.nmd.service.CommentService;
import com.nmd.service.LivestreamService;
import com.nmd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
@RestController
@RequestMapping("/api")
public class ApiComment {
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;
    @Autowired
    private LivestreamService livestreamService;
    
    @GetMapping("/livestream-page/{livestreamID}/comments")
    public ResponseEntity<List<Comment>> getComments(@PathVariable(value = "livestreamID") int id) {
        List<Comment> comments = this.commentService.getComments();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
    
    @PostMapping(path = "/livestream-page/{livestreamID}/comments", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Comment> addComment(@RequestBody Map<String, String> params, 
            @PathVariable(value = "livestreamID") int id, Principal pricipal) {
//        LivestreamDetail p = this.livestreamService.getProductById(id);
//        User u = this.userService.getUserByUsername(pricipal.getName());
//
//        Comment c = new Comment();
//        c.setContent(params.get("content"));
//        c.setProduct(p);
//        c.setUser(u);
//        c.setCreatedDate(new Date());
//        c = this.commentService.addComment(c);
//        System.out.println(c);
//        if (c != null)
//            return new ResponseEntity<>(c, HttpStatus.CREATED);
//
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
