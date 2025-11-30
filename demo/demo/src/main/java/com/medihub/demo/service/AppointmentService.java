package com.medihub.demo.service;

import com.medihub.demo.entity.Appointment;
import com.medihub.demo.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository repo;

    public Appointment create(Appointment a) { return repo.save(a); }
    public List<Appointment> getAll() { return repo.findAll(); }
    public Optional<Appointment> getById(Long id) { return repo.findById(id); }

    public boolean doctorHasConflict(Long doctorId, LocalDateTime dt) {
        List<Appointment> list = repo.findByDoctorIdAndDateTime(doctorId, dt);
        return !list.isEmpty();
    }
}
