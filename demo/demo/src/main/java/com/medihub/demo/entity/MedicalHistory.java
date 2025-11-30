package com.medihub.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "medical_history")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class MedicalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;
    private String patientName;
    private String condition;
    private LocalDate dateRecorded;
    private String notes;
}
