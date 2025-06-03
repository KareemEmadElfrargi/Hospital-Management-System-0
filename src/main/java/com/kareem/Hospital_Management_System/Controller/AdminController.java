package com.kareem.Hospital_Management_System.Controller;

import com.kareem.Hospital_Management_System.Entity.DTO.NurseShiftRequest;
import com.kareem.Hospital_Management_System.Service.ShiftService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final ShiftService shiftService;

    @PostMapping("/assign-shift")
    public ResponseEntity<?> assignShift(@RequestBody NurseShiftRequest request) {
        String result = shiftService.assignShiftToNurse(request.getNurseNationalId(), request.getStart(), request.getEnd());
        return ResponseEntity.ok(result);
    }


}
