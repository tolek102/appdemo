package com.example.appdemo.User;

import java.util.List;

import org.springframework.data.repository.query.Param;

public interface UserServiceInterface {

    User findUserByEmail(String email);
    void saveUser(User user);
    void updateUserPassword(String newPassword, String email);
    void updateUserProfile(String newName, String newLastName, String newEmail, int id);
    List<User> findAll();
}
