package com.kareem.Hospital_Management_System.Service;

import com.kareem.Hospital_Management_System.Entity.DTO.NurseShiftRequest;
import com.kareem.Hospital_Management_System.Entity.Enum.ShiftType;
import com.kareem.Hospital_Management_System.Entity.Nurse;
import com.kareem.Hospital_Management_System.Entity.Shift;
import com.kareem.Hospital_Management_System.Repository.NurseRepository;
import com.kareem.Hospital_Management_System.Repository.ShiftRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShiftService {
    private final ShiftRepository shiftRepository;
    private final NurseRepository nurseRepository;


    public String assignShiftToNurse(NurseShiftRequest request){

        Nurse nurse = nurseRepository.findByNationalId(request.getNurseNationalId())
                .orElseThrow(()->new RuntimeException("Nurse Not Found in Database"));

        ShiftType shiftType;
        try {
            shiftType = ShiftType.valueOf(request.getType().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid shift type. Allowed: MORNING, EVENING, NIGHT");
        }
        Shift shift = Shift.builder()
                .startTime(request.getStart())
                .endTime(request.getEnd())
                .type(shiftType)
                .nurse(nurse)
                .build();

        shiftRepository.save(shift);
        return "Shift assigned to nurse";

    }
    public List<Shift> getShiftsForNurse(String nationalId){
        Nurse nurse = nurseRepository.findByNationalId(nationalId)
                .orElseThrow(() -> new RuntimeException("Nurse Not Found in Database"));
        return shiftRepository.findByNurse(nurse);
    }
}
