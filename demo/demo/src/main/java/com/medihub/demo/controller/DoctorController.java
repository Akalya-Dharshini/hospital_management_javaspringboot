package com.medihub.demo.controller;

import com.medihub.demo.entity.Doctor;
import com.medihub.demo.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService service;

    @GetMapping
    public List<Doctor> all() { return service.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> one(@PathVariable Long id){
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Doctor create(@RequestBody Doctor d){ return service.create(d); }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> update(@PathVariable Long id, @RequestBody Doctor d){
        return service.getById(id).map(existing -> {
            d.setId(existing.getId());
            return ResponseEntity.ok(service.update(d));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
