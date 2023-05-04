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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
    @Override
    public boolean addLivestream(LivestreamDetail detail) {
        if (!detail.getThumbnailFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(detail.getThumbnailFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                detail.setThumbnail(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(LivestreamServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.livestreamRepository.addLivestream(detail);
    }
}
