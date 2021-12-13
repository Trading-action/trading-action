package com.trading.action.entreprise.infra.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    @JsonIgnoreProperties({"id","entreprise"})
    @Nullable
    PriceEntity prixActuel;
    @JsonIgnoreProperties({"id","entreprise"})
    @OneToMany(mappedBy = "entreprise")
    private List<PriceEntity> prixHistorique;
    @JsonIgnoreProperties({"id","entreprises"})
    @ManyToOne
    @Nullable
    private SecteurEntity secteur;
}