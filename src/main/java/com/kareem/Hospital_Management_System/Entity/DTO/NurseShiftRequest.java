package com.kareem.Hospital_Management_System.Entity.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NurseShiftRequest {
    private String nurseNationalId;
    private LocalDateTime start;
    private LocalDateTime end;
}
