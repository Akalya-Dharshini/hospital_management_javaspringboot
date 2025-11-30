package com.medihub.demo.service;

import com.medihub.demo.entity.Doctor;
import com.medihub.demo.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository repo;

    public Doctor create(Doctor d){ return repo.save(d); }
    public Doctor update(Doctor d){ return repo.save(d); }
    public List<Doctor> getAll(){ return repo.findAll(); }
    public Optional<Doctor> getById(Long id){ return repo.findById(id); }
    public void delete(Long id){ repo.deleteById(id); }
}
