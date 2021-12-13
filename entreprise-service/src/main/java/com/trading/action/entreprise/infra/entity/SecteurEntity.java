package com.trading.action.entreprise.infra.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SecteurEntity {
    @Id
    @GeneratedValue
    Long id;
    String libelle;
    @OneToMany(mappedBy = "secteur")
    private List<EntrepriseEntity> entreprises;
}
