package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.service.UserService;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository users;

    @Override
    public User register(User user) {
        return users.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return users.findByEmail(email);
    }
}
