package io.itch._tymon1.Lab3.function;

import io.itch._tymon1.Lab3.Colony;
import io.itch._tymon1.Lab3.dto.GetColoniesResponse;
import io.itch._tymon1.Lab3.dto.GetColonyResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ColonyToResponseFunction implements Function<Colony, GetColonyResponse> {

    @Override
    public GetColonyResponse apply(Colony entity) {
        return GetColonyResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .environment(entity.getEnvironment())
                .mainExport(entity.getMainExport())
                .population(entity.getPopulation())
                .empire(GetColonyResponse.Empire.builder()
                        .id(entity.getEmpire().getId())
                        .build())
                .build();
    }
}
