/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nmd.repository.impl;

import com.nmd.pojo.Comment;
import com.nmd.repository.CommentRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class CommentRepositoryImpl implements CommentRepository {
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<Comment> getComments() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Comment");
        return q.getResultList();
    }

    @Override
    public Comment addComment(Comment c) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            s.save(c);
            return c;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
}