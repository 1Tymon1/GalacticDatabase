package io.itch._tymon1.Lab3.dto;


import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PatchColonyRequest {
    String name;
    long population;
    String mainExport;
}
