/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nmd.repository;

import com.nmd.pojo.Comment;

import java.util.List;

/**
 *
 * @author admin
 */
public interface CommentRepository {
    List<Comment> getComments();
    Comment addComment(Comment c);
}
