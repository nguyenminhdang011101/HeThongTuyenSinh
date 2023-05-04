/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nmd.controllers;

import com.nmd.pojo.LivestreamDetail;
import com.nmd.pojo.User;
import com.nmd.service.LivestreamService;
import com.nmd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author admin
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private LivestreamService livestreamService;
    @Autowired
    private UserService userService;

    @GetMapping("/add-livestream")
    public String addLivestreamView(@ModelAttribute(value = "livestream") LivestreamDetail livestream) {
        return "add-livestream";
    }
    @PostMapping("/add-livestream-action")
    public String addLivestreamAction(Model model, @ModelAttribute(value = "livestream") LivestreamDetail livestream,
                                @PathVariable(value = "userID") int id) {
        System.out.println(id);
        return "add-livestream";
    }
    @ModelAttribute("userList")
    public Map<String, String> getUserList() {
        var admins = userService.getAllAdmin();
        Map<String, String> e = admins.stream().collect(Collectors.toMap(User::getUsername, User::getFullName));
        return e;
    }


}
