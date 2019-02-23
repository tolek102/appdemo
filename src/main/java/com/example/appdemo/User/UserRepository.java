package com.example.appdemo.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    @Modifying
    @Query ("UPDATE User u SET u.password = :newPassword WHERE u.email = :email")
    public void updateUserPassword(@Param("newPassword") String password, @Param("email") String email);
}
