package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {
    User register(User user);
    User findByEmail(String email);
        User updateUser(Long id, User user);
    void deleteUser(Long id);
}
