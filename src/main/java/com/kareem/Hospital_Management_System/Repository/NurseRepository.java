package com.kareem.Hospital_Management_System.Repository;

import com.kareem.Hospital_Management_System.Entity.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NurseRepository extends JpaRepository<Nurse,String> {
    Optional<Nurse> findByNationalId(String nationalId);

}
