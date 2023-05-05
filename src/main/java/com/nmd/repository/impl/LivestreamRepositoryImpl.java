/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nmd.repository.impl;

import com.nmd.pojo.LivestreamDetail;
import com.nmd.repository.LivestreamRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 *
 * @author admin
 */
@Repository
@Transactional
public class LivestreamRepositoryImpl implements LivestreamRepository {
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    @Transactional
    public ResponseEntity<LivestreamDetail> addLivestream(LivestreamDetail detail) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            s.save(detail);
            return new ResponseEntity<>(detail, HttpStatus.OK);
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public LivestreamDetail getLivestreamById(Integer id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(LivestreamDetail.class, id);
    }

    @Override
    public List<LivestreamDetail> getLivestream() {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery<LivestreamDetail> cq = cb.createQuery(LivestreamDetail.class);
        Root<LivestreamDetail> rootEntry = cq.from(LivestreamDetail.class);
        CriteriaQuery<LivestreamDetail> all = cq.select(rootEntry);
        TypedQuery<LivestreamDetail> allQuery = s.createQuery(all);
        return allQuery.getResultList();
    }
}
