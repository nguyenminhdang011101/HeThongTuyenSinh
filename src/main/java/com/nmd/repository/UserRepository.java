/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nmd.repository;

import com.nmd.pojo.User;

import java.util.List;

/**
 *
 * @author admin
 */
public interface UserRepository {
    User getUserByUsername(String username);
    List<User> getAllAdmin();
    boolean register(User user);
}
