package com.kareem.Hospital_Management_System.Entity;

import com.kareem.Hospital_Management_System.Entity.Enum.ShiftType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Shift {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    private ShiftType type;

    @ManyToOne
    @JoinColumn(name = "nurse_national_id", referencedColumnName = "nationalId")
    private Nurse nurse;

}
