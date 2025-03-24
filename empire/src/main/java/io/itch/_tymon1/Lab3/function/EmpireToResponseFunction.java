package io.itch._tymon1.Lab3.function;

import io.itch._tymon1.Lab3.Empire;
import io.itch._tymon1.Lab3.dto.GetEmpireResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class EmpireToResponseFunction implements Function<Empire, GetEmpireResponse> {

    @Override
    public GetEmpireResponse apply(Empire entity) {
        return GetEmpireResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .starSystems(entity.getStarSystems())
                .population(entity.getPopulation())
                .build();
    }
}
