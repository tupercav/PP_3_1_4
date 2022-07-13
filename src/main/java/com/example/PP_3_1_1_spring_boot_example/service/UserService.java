package com.example.PP_3_1_1_spring_boot_example.service;

import com.example.PP_3_1_1_spring_boot_example.model.User;
import com.example.PP_3_1_1_spring_boot_example.repository.RoleRepository;
import com.example.PP_3_1_1_spring_boot_example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

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

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


}
