package com.kareem.Hospital_Management_System;

import com.kareem.Hospital_Management_System.Entity.Enum.Role;
import com.kareem.Hospital_Management_System.Entity.User;
import com.kareem.Hospital_Management_System.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByRole(Role.ADMIN).isEmpty()) {
            User admin = User.builder()
                    .name("Admin")
                    .nationalId("00000000000000")
                    .password(passwordEncoder.encode("admin123"))
                    .role(Role.ADMIN)
                    .build();
            userRepository.save(admin);
            System.out.println("Admin user created with nationalId=00000000000000 and password=admin123");
        }
    }
}
