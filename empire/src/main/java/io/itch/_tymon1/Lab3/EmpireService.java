package io.itch._tymon1.Lab3;

import io.itch._tymon1.Lab3.event.repository.rest.EmpireEventRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmpireService {

    private final EmpireRepository empireRepository;
    private final EmpireEventRestRepository empireEventRestRepository;

    @Autowired
    public EmpireService(EmpireRepository empireRepository, EmpireEventRestRepository empireEventRestRepository) {
        this.empireRepository = empireRepository;
        this.empireEventRestRepository = empireEventRestRepository;
    }

    public List<Empire> findAll() {
        return empireRepository.findAll();
    }

    public Optional<Empire> findById(UUID id) {
        return empireRepository.findById(id);
    }

    public Empire save(Empire empire) {
        //empireEventRestRepository.put(empire.getId());
        return empireRepository.save(empire);
    }

    public void deleteById(UUID id) {
        empireEventRestRepository.delete(id);
        empireRepository.deleteById(id);
    }

    public Optional<Empire> findByName(String name) {
        return empireRepository.findByName(name);
    }

    public Optional<Empire> findByStarSystems(int starSystems) {
        return empireRepository.findByStarSystems(starSystems);
    }

    public Optional<Empire> findByPopulation(int population) {
        return empireRepository.findByPopulation(population);
    }
}
