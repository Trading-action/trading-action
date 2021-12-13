package com.trading.action.entreprise.infra.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class PriceEntity extends AbstractEntity {
    @JsonIgnoreProperties({"id","adress","prixHistorique","prixActuel","dividende"})
    @ManyToOne
    EntrepriseEntity entreprise;
    BigDecimal prix;
}