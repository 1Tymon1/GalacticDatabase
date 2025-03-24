package io.itch._tymon1.Lab3.function;

import io.itch._tymon1.Lab3.Empire;
import io.itch._tymon1.Lab3.dto.PutEmpireRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToEmpire implements BiFunction<UUID, PutEmpireRequest, Empire> {

    @Override
    public Empire apply(UUID uuid, PutEmpireRequest putEmpireRequest) {
        return Empire.builder()
                .id(uuid)
                .name(putEmpireRequest.getName())
                .starSystems(putEmpireRequest.getStarSystems())
                .population(putEmpireRequest.getPopulation())
                .build();
    }
}
