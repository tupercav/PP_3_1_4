package com.example.PP_3_1_1_spring_boot_example.service;


import com.example.PP_3_1_1_spring_boot_example.dao.UserDao;
import com.example.PP_3_1_1_spring_boot_example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void updateUser(User user, int id) {
        userDao.updateUser(user, id);
    }

    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }
}
