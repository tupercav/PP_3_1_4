package com.example.PP_3_1_1_spring_boot_example.dao;






import com.example.PP_3_1_1_spring_boot_example.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    void deleteUserById(int id);
    User getUserById (int id);

    List<User> getAllUsers();

    void updateUser (User user, int id);
    void createUser (User user);






}
