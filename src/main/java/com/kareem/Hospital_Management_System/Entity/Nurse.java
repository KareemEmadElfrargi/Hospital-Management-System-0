package com.kareem.Hospital_Management_System.Entity;

import com.kareem.Hospital_Management_System.Entity.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "nurses_info")
public class Nurse {

    @Id
    @Column(length = 14, unique = true)
    private String nationalId;

    private String name;

    private String phone;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String address;

    private double salary;
    private double bonus;

}
