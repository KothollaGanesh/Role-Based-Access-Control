package com.Assignment.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "Welcome to the Admin Dashboard!";
    }

    @GetMapping("/user/dashboard")
    public String userDashboard() {
        return "Welcome to the User Dashboard!";
    }

    @GetMapping("/")
    public String home() {
        return "Welcome to the Home Page!";
    }
}
