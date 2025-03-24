package io.itch._tymon1.Lab3.function;

import io.itch._tymon1.Lab3.Colony;
import io.itch._tymon1.Lab3.Empire;
import io.itch._tymon1.Lab3.dto.PutColonyRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToColonyFunction implements BiFunction<UUID, PutColonyRequest, Colony> {
    @Override
    public Colony apply(UUID id, PutColonyRequest request) {
        return Colony.builder()
                .id(id)
                .name(request.getName())
                .environment(request.getEnvironment())
                .mainExport(request.getMainExport())
                .population(request.getPopulation())
                .empire(Empire.builder()
                        .id(request.getEmpire())
                        .build())
                .build();
    }
}
