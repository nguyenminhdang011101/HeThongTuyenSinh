/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nmd.repository.impl;

import com.nmd.pojo.LivestreamDetail;
import com.nmd.repository.LivestreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    public boolean addLivestream(LivestreamDetail detail) {
        return false;
    }
}
