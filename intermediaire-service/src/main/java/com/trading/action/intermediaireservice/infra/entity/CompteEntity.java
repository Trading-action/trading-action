package com.irisi.trading.infra.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompteEntity extends AbstractEntity {
    @ManyToOne
    CompteTypeEntity typeCompte;

    @OneToOne
    ActionnaireEntity actionnaire;

}
