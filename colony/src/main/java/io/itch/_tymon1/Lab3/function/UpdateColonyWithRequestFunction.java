package io.itch._tymon1.Lab3.function;

import io.itch._tymon1.Lab3.Colony;
import io.itch._tymon1.Lab3.Empire;
import io.itch._tymon1.Lab3.dto.PatchColonyRequest;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class UpdateColonyWithRequestFunction implements BiFunction<Colony, PatchColonyRequest, Colony> {

    @Override
    public Colony apply(Colony colony, PatchColonyRequest request) {
        colony.setName(request.getName());
        colony.setPopulation(request.getPopulation());
        colony.setMainExport(request.getMainExport());
        return colony;
//        return Colony.builder()
//                .id(colony.getId())
//                .name(request.getName())
//                .environment(colony.getEnvironment())
//                .mainExport(request.getMainExport())
//                .population(request.getPopulation())
//                .empire(colony.getEmpire())
//                .build();
    }
}
