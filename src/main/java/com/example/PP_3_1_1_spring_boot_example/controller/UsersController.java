package com.example.PP_3_1_1_spring_boot_example.controller;


import com.example.PP_3_1_1_spring_boot_example.model.User;
import com.example.PP_3_1_1_spring_boot_example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@Controller
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String userInfo(Model model, Principal principal) {
        model.addAttribute("user", userService.findByUsername(principal.getName()));
        return "users/userinfo";
    }

}


