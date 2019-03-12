package com.example.appdemo.admin;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.appdemo.User.User;

public interface AdminServiceInterface {

    Page<User> findAll(Pageable pageable);
}
