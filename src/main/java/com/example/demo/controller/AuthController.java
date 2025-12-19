package com.example.demo.controller;



@RestController
public class AuthController{
   @Autowired UserService us;
   @PostMapping("/register")
   public User sendData(@RequestBody User user){
    return us.register(user);
   }
}