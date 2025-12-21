package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public User register(User user) {
        if (repo.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("email");
        }
        user.setRole("USER");
        return repo.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return repo.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
    @Override
public User updateUser(Long id, User user) {

    User existingUser = repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));

    existingUser.setName(user.getName());
    existingUser.setEmail(user.getEmail());
    existingUser.setPassword(user.getPassword());
    existingUser.setRole(user.getRole());

    return repo.save(existingUser);
}

@Override
public void deleteUser(Long id) {

    User user = repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));

    repo.delete(user);
}

}
