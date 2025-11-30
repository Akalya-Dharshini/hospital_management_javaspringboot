package com.medihub.demo.repository;

import com.medihub.demo.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDoctorIdAndDateTime(Long doctorId, LocalDateTime dateTime);
}
