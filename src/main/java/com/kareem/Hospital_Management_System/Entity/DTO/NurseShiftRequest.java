package com.kareem.Hospital_Management_System.Entity.DTO;

import com.kareem.Hospital_Management_System.Entity.Enum.ShiftType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NurseShiftRequest {
    private String nurseNationalId;
    private LocalDateTime start;
    private LocalDateTime end;
    private String type;
}
