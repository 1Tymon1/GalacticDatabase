package io.itch._tymon1.Lab3.repository;

import io.itch._tymon1.Lab3.Empire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmpireRepository extends JpaRepository<Empire, UUID> {

}
