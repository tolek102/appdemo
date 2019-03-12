package com.example.appdemo.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.appdemo.User.User;

@Service
@Transactional
public class AdminService implements AdminServiceInterface{

    @Autowired
    AdminRepository adminRepository;

    @Override
    public Page<User> findAll(final Pageable pageable) {
        Page<User> userList = adminRepository.findAll(pageable);
        return userList;
    }

    @Override
    public User findUserById(final int id) {
        User user = adminRepository.findUserById(id);
        return user;
    }

    @Override
    public void updateUser(final int id, final int nrRoli, final int activity) {
        adminRepository.updateActivationUser(activity, id);
        adminRepository.updateRoleUser(nrRoli, id);
    }
}
