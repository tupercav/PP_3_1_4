package com.example.PP_3_1_1_spring_boot_example.repository;

import com.example.PP_3_1_1_spring_boot_example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
