package com.example.PP_3_1_1_spring_boot_example.controller;

import com.example.PP_3_1_1_spring_boot_example.model.Role;
import com.example.PP_3_1_1_spring_boot_example.model.User;
import com.example.PP_3_1_1_spring_boot_example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;



    @GetMapping()
    public String index (Model model, Principal principal) {
        model.addAttribute("currentUser", userService.findByUsername(principal.getName()));
        model.addAttribute("allUsers", userService.getAllUsers());
        model.addAttribute("allRoles", userService.getAllRoles());
        model.addAttribute("newUser", new User());
        return "admin/adminPage";
    }

//    @GetMapping("/{id}/edit")
//    public String editUser (Model model, @PathVariable("id") int id) {
//        model.addAttribute("user", userService.getUserById(id));
//        model.addAttribute("rolesList", userService.getAllRoles());
//        return "admin/edit";
//    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("userToEdit") User user, @ModelAttribute("roles") String[] roles) {

        for (String role : roles) {
            user.getRoles().add(userService.getRole(role));
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute("user") User user, @ModelAttribute("roles") String[] roles) {
        for (String role : roles) {
            user.getRoles().add(userService.getRole(role));
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        return "redirect:/admin";
    }

}
