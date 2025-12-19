package com.example.demo.service.impl;

import com.example.demo.service.UserService;
import com.example.demo.service.UserRepository;
import com.example.demo.repository.UserRepository
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public interface UserServiceImpl implements UserService {
    
@Autowired UserRepository user;
@Override
public User register(User user){

}


@Override

}