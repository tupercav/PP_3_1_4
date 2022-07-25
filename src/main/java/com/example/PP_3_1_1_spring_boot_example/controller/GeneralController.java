package com.example.PP_3_1_1_spring_boot_example.controller;

import com.example.PP_3_1_1_spring_boot_example.repository.RoleRepository;
import com.example.PP_3_1_1_spring_boot_example.repository.UserRepository;
import com.example.PP_3_1_1_spring_boot_example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @GetMapping("/user")
    public String user() {
        return "userinfo";
    }

    @GetMapping("/admin")
    public String admin() {
        return "adminPage";
    }

}
