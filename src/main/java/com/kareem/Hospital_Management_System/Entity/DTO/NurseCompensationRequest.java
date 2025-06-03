package com.kareem.Hospital_Management_System.Entity.DTO;

import lombok.Data;

@Data
public class NurseCompensationRequest {
    private String nurseNationalId;
    private Double salary;
    private Double bonus;
}