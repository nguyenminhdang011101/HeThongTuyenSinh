/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nmd.controllers;

import com.nmd.pojo.Thongtints;
import java.util.ArrayList;
import java.util.List;

import com.nmd.pojo.User;
import com.nmd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 *
 * @author LENOVO-E14
 */
@Controller
public class HomeController {
    @Autowired
    private UserService userService;
    @RequestMapping(path = {"/"})
    public String index(Model model) {
        List<Thongtints> thongtintss = new ArrayList<>();
        thongtintss.add(new Thongtints(1, "Tieude", "Noidung","Thoigian", "https://res.cloudinary.com/dkkhnxowj/image/upload/v1679123124/cld-sample-5.jpg"));
        thongtintss.add(new Thongtints(2, "Tieude", "Noidung","Thoigian", "https://res.cloudinary.com/dkkhnxowj/image/upload/v1679123124/cld-sample-5.jpg"));
        thongtintss.add(new Thongtints(3, "Tieude", "Noidung","Thoigian", "https://res.cloudinary.com/dkkhnxowj/image/upload/v1679123124/cld-sample-5.jpg"));
        model.addAttribute("thongtintss", thongtintss);
        
        return "index";
    }
    @GetMapping("/login")
    public String loginView() {
        return "login";
    }
    @GetMapping("/register")
    public String registerView() {
        return "register";
    }

    @GetMapping("/livestream")
    public String livestreamView() {
        return "livestream";
    }

    @PostMapping("/action-register")
    public String registerAction(Model model,@ModelAttribute(value = "user")  @Valid User user,
                                 BindingResult rs) {
        if (rs.hasErrors()){
            var error = new StringBuilder();
            var errores = rs.getAllErrors();
            for (var err :errores) {
                error.append("<br>-").append(err.getDefaultMessage()).append("</br>");
            }
            model.addAttribute("errMsg", error);
            return "register";
        }
        if(user.getFile().isEmpty()){
            model.addAttribute("errMsg", "Phải chọn avt");
            return "register";
        }
        userService.register(user);
        return "login";
    }
}
