package com.Assignment.demo;

import com.Assignment.demo.entity.Role;
import com.Assignment.demo.entity.User;
import com.Assignment.demo.repository.RoleRepository;
import com.Assignment.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@org.springframework.context.annotation.Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner init(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Add roles
            Role adminRole = roleRepository.findByName("ADMIN");
            if (adminRole == null) {
                adminRole = new Role();
                adminRole.setName("ADMIN");
                roleRepository.save(adminRole);
            }

            Role userRole = roleRepository.findByName("USER");
            if (userRole == null) {
                userRole = new Role();
                userRole.setName("USER");
                roleRepository.save(userRole);
            }

            // Add an admin user
            if (userRepository.findByUsername("admin").isEmpty()) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin123")); // Encode password
                Set<Role> roles = new HashSet<>();
                roles.add(adminRole);
                admin.setRoles(roles);
                userRepository.save(admin);
            }

            // Add a regular user
            if (userRepository.findByUsername("user").isEmpty()) {
                User user = new User();
                user.setUsername("user");
                user.setPassword(passwordEncoder.encode("user123")); // Encode password
                Set<Role> roles = new HashSet<>();
                roles.add(userRole);
                user.setRoles(roles);
                userRepository.save(user);
            }
        };
    }
}
