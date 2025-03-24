package io.itch._tymon1.Lab3.function;

import io.itch._tymon1.Lab3.Empire;
import io.itch._tymon1.Lab3.dto.GetEmpiresResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class EmpiresToResponseFunction implements Function<List<Empire>, GetEmpiresResponse> {
    @Override
    public GetEmpiresResponse apply(List<Empire> entities) {
        return GetEmpiresResponse.builder()
                .empires(entities.stream()
                        .map(profession -> GetEmpiresResponse.Empire.builder()
                                .id(profession.getId())
                                .name(profession.getName())
                                .build())
                        .toList())
                .build();

    }
}
