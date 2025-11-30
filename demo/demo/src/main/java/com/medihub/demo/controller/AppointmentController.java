package com.medihub.demo.controller;

import com.medihub.demo.entity.Appointment;
import com.medihub.demo.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService service;

    @GetMapping
    public List<Appointment> all() {
        return service.getAll();
    }

    @PostMapping("/book")
    public ResponseEntity<?> book(@RequestBody Map<String, String> body) {
        try {
            Long patientId = Long.valueOf(body.getOrDefault("patientId", "0"));
            Long doctorId = Long.valueOf(body.get("doctorId"));
            String patientName = body.getOrDefault("patientName", "Unknown Patient");
            String doctorName = body.getOrDefault("doctorName", "Unknown Doctor");
            LocalDateTime dateTime = LocalDateTime.parse(body.get("dateTime")); // must be ISO

            if (service.doctorHasConflict(doctorId, dateTime)) {
                return ResponseEntity.badRequest().body(Map.of("error", "Doctor already has an appointment at this time"));
            }

            Appointment appt = new Appointment();
            appt.setPatientId(patientId);
            appt.setDoctorId(doctorId);
            appt.setPatientName(patientName);
            appt.setDoctorName(doctorName);
            appt.setDateTime(dateTime);
            appt.setStatus("BOOKED");

            Appointment saved = service.create(appt);
            return ResponseEntity.ok(saved);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(Map.of("error", e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.getById(id).ifPresent(service::create);
        return ResponseEntity.ok().build();
    }
}
