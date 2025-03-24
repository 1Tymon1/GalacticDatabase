package io.itch._tymon1.Lab3.event.repository.rest;

import io.itch._tymon1.Lab3.event.repository.api.EmpireEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class EmpireEventRestRepository implements EmpireEventRepository {
    private final RestTemplate restTemplate;

    @Autowired
    public EmpireEventRestRepository(RestTemplate template) {
        this.restTemplate = template;
    }

    @Override
    public void delete(UUID id) {
        System.out.println("Deleting empire event: " + id);
        restTemplate.delete("/api/empires/{id}", id);
    }

    @Override
    public void put(UUID id, UUID id2) {
        System.out.println("Updating empire event: " + id);
        restTemplate.put("/api/empires/{id}", id, id2);
    }

}
