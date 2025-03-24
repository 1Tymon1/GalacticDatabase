package io.itch._tymon1.Lab3.function;

import io.itch._tymon1.Lab3.Colony;
import io.itch._tymon1.Lab3.dto.GetColoniesResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class ColoniesToResponseFunction implements Function<List<Colony>, GetColoniesResponse> {

    @Override
    public GetColoniesResponse apply(List<Colony> entities) {
        return GetColoniesResponse.builder()
                .colonies(entities.stream()
                        .map(character -> GetColoniesResponse.Colony.builder()
                                .id(character.getId())
                                .name(character.getName())
                                .build())
                        .toList())
                .build();

    }
}
