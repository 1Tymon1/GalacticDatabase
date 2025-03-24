package io.itch._tymon1.Lab3.dto;

import lombok.*;

import java.util.UUID;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutEmpireRequest {
    String name;

    int starSystems;

    long population;
}
