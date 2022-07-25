package com.example.PP_3_1_1_spring_boot_example;

import com.example.PP_3_1_1_spring_boot_example.model.Role;
import com.example.PP_3_1_1_spring_boot_example.model.User;
import com.example.PP_3_1_1_spring_boot_example.repository.RoleRepository;
import com.example.PP_3_1_1_spring_boot_example.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class Init {
    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public Init(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void Init(){
        User admin = new User("Pavel", "Zhalnin", "IT", 300, "admin", passwordEncoder.encode("admin"));
        User user = new User("Vika", "Tikhonicheva", "Logistic", 300, "user", passwordEncoder.encode("user"));

        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        roleRepository.save(roleAdmin);
        roleRepository.save(roleUser);

        Set<Role> adminRoles = new HashSet<>();
        Set<Role> userRoles = new HashSet<>();

        adminRoles.add(roleAdmin);
        userRoles.add(roleUser);

        admin.setRoles(adminRoles);
        user.setRoles(userRoles);

        userRepository.save(admin);
        userRepository.save(user);

    }
}
