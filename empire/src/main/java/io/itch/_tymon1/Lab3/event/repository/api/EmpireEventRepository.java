package io.itch._tymon1.Lab3.event.repository.api;

import java.util.UUID;

public interface EmpireEventRepository {
    void delete(UUID id);
    void put(UUID id, UUID id2);
}
