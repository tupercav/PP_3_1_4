package com.example.PP_3_1_1_spring_boot_example.controller;

import com.example.PP_3_1_1_spring_boot_example.model.User;
import com.example.PP_3_1_1_spring_boot_example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;


    @GetMapping()
    public String index (Model model) {
        model.addAttribute("userList", userService.getAllUsers());
        return "admin/adminPage";
    }

    @GetMapping("/{id}/edit")
    public String editUser (Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "admin/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }

    @GetMapping("/new")
    public String newUser (@ModelAttribute("user") User user) {
        return "admin/new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        return "redirect:/admin";
    }

}
