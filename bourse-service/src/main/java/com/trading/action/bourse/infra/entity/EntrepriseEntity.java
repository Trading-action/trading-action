package com.trading.action.bourse.infra.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
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