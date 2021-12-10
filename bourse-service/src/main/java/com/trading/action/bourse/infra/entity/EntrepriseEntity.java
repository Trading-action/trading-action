package com.trading.action.bourse.infra.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EntrepriseEntity extends AbstractEntity {
    String libelle;
    String adress;
    BigDecimal nombreAction;
    BigDecimal dividende;
    @OneToOne
    @Nullable
    PriceEntity prixActuel;
    @OneToMany(mappedBy = "entreprise")
    private List<PriceEntity> prixHistorique;
}