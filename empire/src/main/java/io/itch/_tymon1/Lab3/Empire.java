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
public class Empire implements Comparable<Empire>, Serializable {
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name="name")
    String name;
    @Column(name="star_systems")
    int starSystems;
    @Column
    long population;

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
        {
            return true;
        }
        if (obj.getClass() == this.getClass())
        {
            if (compareTo((Empire)obj) == 0)
            {
                return true;
            }
        }
        return false;
    }

    //task1
    @Override
    public int compareTo(Empire o) {
        if (starSystems < o.starSystems)
        {
            return 1;
        }
        else if (starSystems > o.starSystems)
        {
            return -1;
        }
        else
        {
            return name.compareTo(o.name);
        }
    }
}

