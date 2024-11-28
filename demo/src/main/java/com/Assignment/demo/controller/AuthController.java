package com.Assignment.demo.controller;

import com.Assignment.demo.entity.Role;
import com.Assignment.demo.entity.User;
import com.Assignment.demo.repository.RoleRepository;
import com.Assignment.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        Role userRole = roleRepository.findByName("USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singleton(userRole));
        userRepository.save(user);
        return "User registered successfully!";
    }

    @PostMapping("/admin/register")
    public String registerAdmin(@RequestBody User user) {
        Role adminRole = roleRepository.findByName("ADMIN");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singleton(adminRole));
        userRepository.save(user);
        return "Admin registered successfully!";
    }
}
