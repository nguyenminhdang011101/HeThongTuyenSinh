/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nmd.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.nmd.pojo.Comment;
import com.nmd.pojo.LivestreamDetail;
import com.nmd.pojo.User;
import com.nmd.service.LivestreamService;
import com.nmd.service.UserService;
import com.nmd.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public String addLivestreamAction(Model model, @RequestParam("username") String username
            , @ModelAttribute(value = "livestream") @Valid LivestreamDetail livestream, BindingResult rs) {
        if(username == null){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            model.addAttribute("errMsg", "Phải assign người phụ trách");
            return "add-livestream";
        }
        if (rs.hasErrors()){
            var error = new StringBuilder();
            var errores = rs.getAllErrors();
            for (var err :errores) {
                error.append("<br>-").append(err.getDefaultMessage()).append("</br>");
            }
            model.addAttribute("errMsg", error);
            return "add-livestream";
            //return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (livestream.getThumbnailFile().isEmpty()) {
            model.addAttribute("errMsg", "Phải chọn thumbnail");
            return "add-livestream";
            //return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        if (livestream.getVideoFile().isEmpty()) {
            model.addAttribute("errMsg", "Phải chọn video");
            return "add-livestream";
            //return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        var res = livestreamService.addLivestream(username, livestream);
        if(res.getStatusCode() == HttpStatus.BAD_REQUEST){
            model.addAttribute("errMsg", "Có lỗi xảy ra lúc upload");
            return "add-livestream";
        }
        model.addAttribute("livestream", livestream);
        return "livestream";
    }
    @ModelAttribute("userList")
    public Map<String, String> getUserList() {
        var admins = userService.getAllAdmin();
        Map<String, String> e = admins.stream().collect(Collectors.toMap(User::getUsername, User::getFullName));
        return e;
    }


}
