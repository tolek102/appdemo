package com.example.appdemo.admin;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.appdemo.User.User;

public interface AdminServiceInterface {

    Page<User> findAll(Pageable pageable);
    User findUserById(int id);
    void updateUser(int id, int nrRoli, int activity);
    Page<User> findAllSearch(String param, final Pageable pageable);

}
