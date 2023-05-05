/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nmd.service;

import com.nmd.pojo.LivestreamDetail;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 *
 * @author admin
 */
public interface LivestreamService {
    ResponseEntity<LivestreamDetail> addLivestream(String username, LivestreamDetail detail);
    LivestreamDetail getLivestreamById(Integer id);
    List<LivestreamDetail> getLivestream();
}
