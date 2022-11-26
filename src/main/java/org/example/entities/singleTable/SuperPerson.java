package org.example.entities.singleTable;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.enums.SuperSkill;

import javax.persistence.*;

@Entity
@DiscriminatorValue("SP")
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SuperPerson extends Person {

    @Enumerated(EnumType.STRING)
    @Column(name = "super_skill")
    SuperSkill superSkill;
}
