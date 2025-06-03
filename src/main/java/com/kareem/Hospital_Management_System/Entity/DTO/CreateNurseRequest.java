package com.kareem.Hospital_Management_System.Entity.DTO;

import lombok.Data;

@Data
public class CreateNurseRequest {

    private String name;
    private String nationalId;
    private String password;
    private String phone;
    private String gender;
    private String address;
}