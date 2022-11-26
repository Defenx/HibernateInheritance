package org.example.entities.singleTable;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.example.enums.MegaSkill;

import javax.persistence.*;

@Entity
@DiscriminatorValue("MP")
@Getter
@Setter
@ToString(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MegaPerson extends Person {

    @Enumerated(EnumType.STRING)
    @Column(name = "mega_skill")
    MegaSkill megaSkill;
}
