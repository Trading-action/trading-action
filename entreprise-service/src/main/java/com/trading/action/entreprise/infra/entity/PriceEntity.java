package com.trading.action.entreprise.infra.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class PriceEntity extends AbstractEntity {
    @JsonIgnoreProperties({"id","adress","prixHistorique","prixActuel","dividende"})
    @ManyToOne
    @Getter(onMethod = @__(@JsonIgnore))
    @Setter
    EntrepriseEntity entreprise;
    BigDecimal prix;
}
