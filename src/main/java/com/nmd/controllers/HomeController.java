/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nmd.controllers;

import cm.nmd.pojo.Thongtints;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author LENOVO-E14
 */
@Controller
public class HomeController {
    @RequestMapping(path = {"/"})
    public String index(Model model) {
        List<Thongtints> thongtintss = new ArrayList<>();
        thongtintss.add(new Thongtints(1, "Tieude", "Noidung","Thoigian", "https://res.cloudinary.com/dkkhnxowj/image/upload/v1679123124/cld-sample-5.jpg"));
        thongtintss.add(new Thongtints(2, "Tieude", "Noidung","Thoigian", "https://res.cloudinary.com/dkkhnxowj/image/upload/v1679123124/cld-sample-5.jpg"));
        thongtintss.add(new Thongtints(3, "Tieude", "Noidung","Thoigian", "https://res.cloudinary.com/dkkhnxowj/image/upload/v1679123124/cld-sample-5.jpg"));
        model.addAttribute("thongtintss", thongtintss);
        
        return "index";
    }
}
