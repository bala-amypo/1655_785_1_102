package com.example.demo.service.impl;

import com.example.demo.service.UserService;
import com.example.demo.service.UserRepository;
import com.example.demo.repository.UserRepository
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public interface UserServiceImpl implements UserService {
    
@Autowired UserRepository users;
@Override
public User register(User user){

return users.save(user)
}

@Override
public User findByEmail(String email){

return users.

}
}