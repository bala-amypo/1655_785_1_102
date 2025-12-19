package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.service.UserService;
import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class AuthController{
   @Autowired UserService us;
   @PostMapping("/register")
   public User sendData(@RequestBody User user){
    return us.register(user);
   }
}