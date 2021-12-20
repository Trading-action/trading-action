package com.trading.clientservice.infra.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompteTypeEntity extends AbstractEntity {

    @OneToMany(mappedBy = "typeCompte")
    @ToString.Exclude
    List<CompteEntity> comptes;
    String libelle;


}
