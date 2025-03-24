package io.itch._tymon1.Lab3.service.impl;

import io.itch._tymon1.Lab3.Empire;
import io.itch._tymon1.Lab3.repository.EmpireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmpireService {

    private final EmpireRepository empireRepository;

    @Autowired
    public EmpireService(EmpireRepository empireRepository) {
        this.empireRepository = empireRepository;
    }

    public Optional<Empire> findById(UUID id) {
        return empireRepository.findById(id);
    }

    public Empire save(Empire empire) {
        return empireRepository.save(empire);
    }

    public void deleteById(UUID id) {
        empireRepository.deleteById(id);
    }

}
