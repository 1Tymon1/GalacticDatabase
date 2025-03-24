package io.itch._tymon1.Lab3;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "colonies")
public class Colony implements Comparable<Colony>, Serializable {
    @Id
    @Column(name = "id")
    private UUID id = UUID.randomUUID();
    @Column
    String name;
    @Column
    long population;
    @Column
    String environment;
    @Column(name="main_export")
    String mainExport;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empire")
    Empire empire;


    @Override
    public boolean equals(Object obj) {
        if (obj == this)
        {
            return true;
        }
        if (obj.getClass() == this.getClass())
        {
            if (compareTo((Colony) obj) == 0)
            {
                return true;
            }
        }
        return false;
    }

    //task1
    @Override
    public int compareTo(Colony o) {
        if (population > o.population)
        {
            return 1;
        }
        else if (population < o.population)
        {
            return -1;
        }
        else
        {
            return name.compareTo(o.name);
        }
    }
}

