package com.example.demo.service.impl;

import com.example.demo.service.UserService;
import com.example.demo.service.UserRepository;
import org.springframework.stereotype.Service;



@Service
public interface UserServiceImpl implements UserService {
    
@Autowired UserRepository user;
@Override
    
}