package io.itch._tymon1.Lab3.repository;

import io.itch._tymon1.Lab3.Colony;
import io.itch._tymon1.Lab3.Empire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ColonyRepository extends JpaRepository<Colony, UUID> {
    Optional<Colony> findByName(String name);
    Optional<Colony> findByPopulation(int population);
    Optional<Colony> findByEnvironment(String environment);
    Optional<Colony> findByMainExport(String mainExport);
    Optional<List<Colony>> findByEmpire(Empire empire);
}
