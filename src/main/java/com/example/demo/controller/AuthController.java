package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.find.

@RestController
public class AuthController{
   @Autowired UserService us;
   @PostMapping("/register")
   public User sendData(@RequestBody User user){
    return us.register(user);
   }
}