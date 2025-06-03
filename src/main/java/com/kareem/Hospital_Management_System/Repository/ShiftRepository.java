package com.kareem.Hospital_Management_System.Repository;

import com.kareem.Hospital_Management_System.Entity.Nurse;
import com.kareem.Hospital_Management_System.Entity.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ShiftRepository extends JpaRepository<Shift, Long> {
    List<Shift> findByNurse(Nurse nurse);
}
