package com.trading.clientservice.infra.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompteTypeEntity extends AbstractEntity {

    @OneToMany(mappedBy = "typeCompte")
    List<CompteEntity> comptes;
    String libelle;
}
