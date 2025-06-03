package com.kareem.Hospital_Management_System.Service;

import com.kareem.Hospital_Management_System.Entity.DTO.CreateNurseRequest;
import com.kareem.Hospital_Management_System.Entity.DTO.LoginRequest;
import com.kareem.Hospital_Management_System.Entity.DTO.LoginResponse;
import com.kareem.Hospital_Management_System.Entity.Enum.Gender;
import com.kareem.Hospital_Management_System.Entity.Enum.Role;
import com.kareem.Hospital_Management_System.Entity.Nurse;
import com.kareem.Hospital_Management_System.Entity.User;
import com.kareem.Hospital_Management_System.Repository.NurseRepository;
import com.kareem.Hospital_Management_System.Repository.UserRepository;
import com.kareem.Hospital_Management_System.Security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final NurseRepository nurseRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public String createNurse(CreateNurseRequest request, Authentication authentication) {
        User currentUser = userRepository.findByNationalId(authentication.getName())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!Role.ADMIN.equals(currentUser.getRole())) {
            throw new RuntimeException("Only admins can create nurses Account");
        }

        if (userRepository.findByNationalId(request.getNationalId()).isPresent()) {
            throw new RuntimeException("National ID already exists");
        }

        User nurseUser = User.builder()
                .name(request.getName())
                .nationalId(request.getNationalId())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.NURSE)
                .build();

        Nurse nurseInfo = Nurse.builder()
                .nationalId(request.getNationalId())
                .name(request.getName())
                .phone(request.getPhone())
                .gender(Gender.valueOf(request.getGender().toUpperCase()))
                .address(request.getAddress())
                .build();

        nurseRepository.save(nurseInfo);
        userRepository.save(nurseUser);
        return "Nurse created successfully";
    }

    public String login(LoginRequest request) {
        User user = userRepository.findByNationalId(request.getNationalId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtService.generateToken(user.getNationalId());
    }



}
