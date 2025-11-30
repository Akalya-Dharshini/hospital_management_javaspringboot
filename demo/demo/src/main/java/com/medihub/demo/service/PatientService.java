package com.medihub.demo.service;

import com.medihub.demo.entity.Patient;
import com.medihub.demo.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository repo;

    public Patient create(Patient p){ return repo.save(p); }
    public Patient update(Patient p){ return repo.save(p); }
    public List<Patient> getAll(){ return repo.findAll(); }
    public Optional<Patient> getById(Long id){ return repo.findById(id); }
    public void delete(Long id){ repo.deleteById(id); }
}
