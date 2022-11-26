package org.example.entities.joined;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class OperationSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "my_seq")
    @SequenceGenerator(name = "my_seq",
            sequenceName = "my_sequence", allocationSize = 1)
    Integer id;

    String name;
}
