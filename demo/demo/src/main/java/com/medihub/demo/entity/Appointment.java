package com.medihub.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTime;
    private Long doctorId;
    private String doctorName;
    private Long patientId;
    private String patientName;
    private String status;

    @PrePersist
    public void setDefaults() {
        if (status == null) status = "BOOKED";
        if (patientName == null || patientName.isBlank()) patientName = "Unknown Patient";
        if (doctorName == null || doctorName.isBlank()) doctorName = "Unknown Doctor";
    }
}
