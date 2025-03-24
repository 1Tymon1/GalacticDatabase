package io.itch._tymon1.Lab3.function;


import io.itch._tymon1.Lab3.Empire;
import io.itch._tymon1.Lab3.dto.PatchEmpireRequest;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class UpdateEmpireWithRequest implements BiFunction<Empire, PatchEmpireRequest, Empire> {

    @Override
    public Empire apply(Empire empire, PatchEmpireRequest patchEmpireRequest) {
        return Empire.builder()
                .id(empire.getId())
                .name(empire.getName())
                .starSystems(patchEmpireRequest.getStarSystems())
                .population(patchEmpireRequest.getPopulation())
                .build();
    }
}
