package com.example.appdemo.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appdemo.User.User;

@Repository
public interface AdminRepository extends JpaRepository<User, Integer> {


}
