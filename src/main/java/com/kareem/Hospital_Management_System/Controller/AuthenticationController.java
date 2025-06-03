package com.kareem.Hospital_Management_System.Controller;

import com.kareem.Hospital_Management_System.Entity.DTO.CreateNurseRequest;
import com.kareem.Hospital_Management_System.Entity.DTO.LoginRequest;
import com.kareem.Hospital_Management_System.Entity.DTO.LoginResponse;
import com.kareem.Hospital_Management_System.Service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        LoginResponse response = authenticationService.login(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create-nurse")
    public ResponseEntity<String> createNurse(@RequestBody CreateNurseRequest request, Authentication authentication) {
        String result = authenticationService.createNurse(request, authentication);
        return ResponseEntity.ok(result);
    }
}