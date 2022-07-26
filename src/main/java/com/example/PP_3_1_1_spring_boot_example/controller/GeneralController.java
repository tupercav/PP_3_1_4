package com.example.PP_3_1_1_spring_boot_example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {
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
