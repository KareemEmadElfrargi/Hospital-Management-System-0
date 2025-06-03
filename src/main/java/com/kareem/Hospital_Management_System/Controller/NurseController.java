package com.kareem.Hospital_Management_System.Controller;

import com.kareem.Hospital_Management_System.Service.ShiftService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nurses")
@RequiredArgsConstructor
public class NurseController {
    private final ShiftService shiftService;

    @GetMapping("/my-shifts")
    public ResponseEntity<?> getMyShifts(Authentication authentication) {
        String nationalId = authentication.getName();
        return ResponseEntity.ok(shiftService.getShiftsForNurse(nationalId));
    }

}
