package io.itch._tymon1.Lab3;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "colonies")
@Entity
@Table(name = "empires")
public class Empire implements Serializable {
    @Id
    @Column(name = "id")
    private UUID id;

    @OneToMany(mappedBy = "empire", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Colony> colonies;

}

