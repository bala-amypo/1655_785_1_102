package com.example.demo.controller;



@RestController
public class AuthController{
   @Autowired UserService us;
   @PostMapping("/auth/register")
   public User sendData(@RequestBody User user){
    return us.register(user);
   }
   @PostMapping("/auth/login")
   public  findByemail(@RequestBody User user){
    return us.register(email);
   }

}