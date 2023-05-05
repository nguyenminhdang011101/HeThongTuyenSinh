/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nmd.repository;

import com.nmd.pojo.LivestreamDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 *
 * @author admin
 */
public interface LivestreamRepository {

    ResponseEntity<LivestreamDetail> addLivestream(LivestreamDetail detail);

    LivestreamDetail getLivestreamById(Integer id);

    List<LivestreamDetail> getLivestream();
}
