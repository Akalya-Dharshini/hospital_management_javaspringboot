package com.medihub.demo.controller;

import com.medihub.demo.entity.MedicalHistory;
import com.medihub.demo.service.MedicalHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/history")
@RequiredArgsConstructor
public class MedicalHistoryController {
    private final MedicalHistoryService service;

    @GetMapping
    public List<MedicalHistory> all(){ return service.getAll(); }

    @GetMapping("/patient/{patientId}")
    public List<MedicalHistory> forPatient(@PathVariable Long patientId){
        return service.getByPatientId(patientId);
    }

    @PostMapping
    public MedicalHistory create(@RequestBody MedicalHistory m){ return service.create(m); }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
