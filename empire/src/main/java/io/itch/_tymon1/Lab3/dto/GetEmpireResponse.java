package io.itch._tymon1.Lab3.dto;


import jakarta.persistence.Column;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetEmpireResponse {
    private UUID id = UUID.randomUUID();
    String name;
    int starSystems;
    long population;
}
