package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class AuthController {

    private final UserService service;

    public AuthController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    @GetMapping("/email/{email}")
    public User getByEmail(@PathVariable String email) {
        return service.findByEmail(email);
    }
    @PutMapping("/{id}")
public User updateUser(@PathVariable Long id, @RequestBody User user) {
    return service.updateUser(id, user);
}

@DeleteMapping("/{id}")
public String deleteUser(@PathVariable Long id) {
    service.deleteUser(id);
    return "User deleted successfully";
}

}
