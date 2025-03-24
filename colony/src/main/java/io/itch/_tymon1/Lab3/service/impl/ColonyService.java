package io.itch._tymon1.Lab3.service.impl;

import io.itch._tymon1.Lab3.Colony;
import io.itch._tymon1.Lab3.repository.ColonyRepository;
import io.itch._tymon1.Lab3.Empire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ColonyService {

    private final ColonyRepository colonyRepository;

    @Autowired
    public ColonyService(ColonyRepository colonyRepository) {
        this.colonyRepository = colonyRepository;
    }

    public List<Colony> findAll() {
        return colonyRepository.findAll();
    }

    public Optional<Colony> findById(UUID id) {
        return colonyRepository.findById(id);
    }

    public Colony save(Colony colony) {
        return colonyRepository.save(colony);
    }

    public void deleteById(UUID id) {
        colonyRepository.deleteById(id);
    }

    public Optional<Colony> findByName(String name) {
        return colonyRepository.findByName(name);
    }

    public Optional<Colony> findByPopulation(int population) {
        return colonyRepository.findByPopulation(population);
    }

    public Optional<Colony> findByEnvironment(String environment) {
        return colonyRepository.findByEnvironment(environment);
    }

    public Optional<Colony> findByMainExport(String mainExport) {
        return colonyRepository.findByMainExport(mainExport);
    }

    public Optional<List<Colony>> findByEmpire(Empire empire) {
        return colonyRepository.findByEmpire(empire);
    }
}