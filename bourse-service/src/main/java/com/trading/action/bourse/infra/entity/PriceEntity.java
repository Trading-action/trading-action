package com.trading.action.bourse.infra.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
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

    @ManyToOne
    @Getter(onMethod = @__(@JsonIgnore))
    @Setter
    EntrepriseEntity entreprise;
    BigDecimal prix;
}
