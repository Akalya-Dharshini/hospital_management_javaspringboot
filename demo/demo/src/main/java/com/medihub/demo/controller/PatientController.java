package com.medihub.demo.controller;

import com.medihub.demo.entity.Patient;
import com.medihub.demo.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService service;

    @GetMapping
    public List<Patient> all(){ return service.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> one(@PathVariable Long id){
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Patient create(@RequestBody Patient p){ return service.create(p); }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> update(@PathVariable Long id, @RequestBody Patient p){
        return service.getById(id).map(existing -> {
            p.setId(existing.getId());
            return ResponseEntity.ok(service.update(p));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
