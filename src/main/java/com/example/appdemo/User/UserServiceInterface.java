package com.example.appdemo.User;

public interface UserServiceInterface {

    User findUserByEmail(String email);
    void saveUser(User user);
}
