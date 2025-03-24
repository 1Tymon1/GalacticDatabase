package io.itch._tymon1.Lab3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmpireRepository extends JpaRepository<Empire, UUID> {
    Optional<Empire> findByName(String name);
    Optional<Empire> findByStarSystems(int starSystems);
    Optional<Empire> findByPopulation(int population);

}
