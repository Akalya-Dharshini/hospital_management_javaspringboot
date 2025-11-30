package com.medihub.demo.service;

import com.medihub.demo.entity.MedicalHistory;
import com.medihub.demo.repository.MedicalHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicalHistoryService {
    private final MedicalHistoryRepository repo;

    public MedicalHistory create(MedicalHistory m){ return repo.save(m); }
    public List<MedicalHistory> getAll(){ return repo.findAll(); }
    public Optional<MedicalHistory> getById(Long id){ return repo.findById(id); }
    public List<MedicalHistory> getByPatientId(Long patientId){ return repo.findByPatientId(patientId); }
    public void delete(Long id){ repo.deleteById(id); }
}
