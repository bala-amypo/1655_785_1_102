package com.example.demo.service.impl;

import org.springframework.stereotype.Service

@Service
public interface UserServiceImpl implements UserService {
    
@Autowired UserRepository user;

    
}