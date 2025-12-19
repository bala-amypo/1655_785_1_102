package com.example.demo.controller;



@RestController
public class AuthController{
   @Autowired UserService us;
   @PostMapping("/auth/register")
   public User sendData(@RequestBody User user){
    return us.register(user);
   }
   
   @PostMapping("/login")
   public  findByEmail(@RequestBody User user){
    return us.(email);
   }

}