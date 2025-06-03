package com.kareem.Hospital_Management_System.Entity.DTO;

import lombok.Data;

@Data
public class LoginRequest {
    private String nationalId;
    private String password;
}
