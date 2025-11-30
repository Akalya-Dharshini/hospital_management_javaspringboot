package com.medihub.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String specialization;
    private String bio;
    private String phone; // only this, remove contact
    private String email;

    @PrePersist
    @PreUpdate
    public void setDefaults() {
        if (bio == null || bio.isBlank()) bio = "No bio provided";
        if (phone == null || phone.isBlank()) phone = "0000000000";
        if (email == null || email.isBlank()) email = "noemail@domain.com";
    }
}
