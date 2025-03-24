package io.itch._tymon1.Lab3.dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PatchEmpireRequest {
    int starSystems;

    long population;
}
