package com.example.PP_3_1_1_spring_boot_example.service;

import com.example.PP_3_1_1_spring_boot_example.model.User;
import com.example.PP_3_1_1_spring_boot_example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.getOne(id);
    }

    public void deleteUserById (int id) {
        userRepository.deleteById(id);
    }

    public void saveUser (User user) {
        userRepository.save(user);
    }

}
