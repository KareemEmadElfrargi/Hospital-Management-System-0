package com.kareem.Hospital_Management_System.Service;

import com.kareem.Hospital_Management_System.Entity.DTO.NurseFinancialInfo;
import com.kareem.Hospital_Management_System.Entity.Nurse;
import com.kareem.Hospital_Management_System.Repository.NurseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NurseService {
    private final NurseRepository nurseRepository;

    public String updateSalary(String nationalId, Double salary){
        Nurse nurse = nurseRepository.findByNationalId(nationalId)
                .orElseThrow(() -> new RuntimeException("Nurse not found"));

        nurse.setSalary(salary);
        nurseRepository.save(nurse);
        return "Salary updated successfully";
    }

    public String setBonus(String nationalId , Double bonus){
        Nurse nurse = nurseRepository.findByNationalId(nationalId)
                .orElseThrow(() -> new RuntimeException("Nurse not found"));
        nurse.setBonus(bonus);
        nurseRepository.save(nurse);
        return "Bonus added successfully";
    }

    public NurseFinancialInfo getMyFinancialInfo(String nationalId){
        Nurse nurse = nurseRepository.findByNationalId(nationalId)
                .orElseThrow(() -> new RuntimeException("Nurse not found"));

        return new NurseFinancialInfo(nurse.getSalary(), nurse.getBonus());
    }
}
