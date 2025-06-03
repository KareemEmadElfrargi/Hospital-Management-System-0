package com.kareem.Hospital_Management_System.Controller;

import com.kareem.Hospital_Management_System.Entity.DTO.NurseCompensationRequest;
import com.kareem.Hospital_Management_System.Entity.DTO.NurseShiftRequest;
import com.kareem.Hospital_Management_System.Service.NurseService;
import com.kareem.Hospital_Management_System.Service.ShiftService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supervisor")
@RequiredArgsConstructor
public class SupervisorController {
    private final ShiftService shiftService;
    private final NurseService nurseService;

    @PostMapping("/assign-shift")
    public ResponseEntity<?> assignShift(@RequestBody NurseShiftRequest request) {
        String result = shiftService.assignShiftToNurse(request);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/set-salary")
    public ResponseEntity<String> setSalary(@RequestBody NurseCompensationRequest request) {
        String result = nurseService.updateSalary(request.getNurseNationalId(), request.getSalary());
        return ResponseEntity.ok(result);
    }

    @PostMapping("/set-bonus")
    public ResponseEntity<String> setCompensation(@RequestBody NurseCompensationRequest request) {
        String result = nurseService.setBonus(
                request.getNurseNationalId(),
                request.getBonus()
        );
        return ResponseEntity.ok(result);
    }

    @GetMapping("/my-financial-info")
    public ResponseEntity<?> getMyFinancialInfo(Authentication authentication) {
        String nationalId = authentication.getName();
        return ResponseEntity.ok(nurseService.getMyFinancialInfo(nationalId));
    }



}
