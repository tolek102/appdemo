package com.example.appdemo.User;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService implements UserServiceInterface {

   @Autowired
   private UserRepository userRepository;

   @Autowired
   private RoleRepository roleRepository;

   @Autowired
   private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);

        Role role = roleRepository.findByRole("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(role)));

        userRepository.save(user);

    }

    @Override
    public void updateUserPassword(final String newPassword, final String email) {
        userRepository.updateUserPassword(bCryptPasswordEncoder.encode(newPassword), email);
    }

    @Override
    public void updateUserProfile(final String newName, final String newLastName, final String newEmail, final int id) {
        userRepository.updateUserProfile(newName, newLastName, newEmail, id);

    }

    @Override
    public List<User> findAll() {
        List<User> userList= userRepository.findAll();
        return userList;
    }
}
