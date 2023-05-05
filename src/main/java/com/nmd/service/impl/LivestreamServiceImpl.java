/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nmd.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.nmd.pojo.LivestreamDetail;
import com.nmd.repository.LivestreamRepository;
import com.nmd.service.LivestreamService;
import com.nmd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Calendar;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
@Service
public class LivestreamServiceImpl implements LivestreamService {
    @Autowired
    private LivestreamRepository livestreamRepository;
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<LivestreamDetail> addLivestream(String username, LivestreamDetail detail) {

        try {
            Map res = this.cloudinary.uploader().upload(detail.getThumbnailFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            detail.setThumbnail(res.get("secure_url").toString());
        } catch (IOException ex) {
            Logger.getLogger(LivestreamServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        try {
            Map res = this.cloudinary.uploader().upload(detail.getVideoFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            detail.setVideo(res.get("secure_url").toString());
        } catch (IOException ex) {
            Logger.getLogger(LivestreamServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        var user = userService.getUserByUsername(username);
        detail.setCreatedDate(Calendar.getInstance().getTime());
        detail.setPersonInCharge(user);
        return livestreamRepository.addLivestream(detail);
    }
}
