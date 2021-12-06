package com.trading.action.clientservice.infra.entity;


import com.trading.action.clientservice.domain.pojo.Actionnaire;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.Instant;


@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ActionEntity extends AbstractEntity{

    @ManyToOne
    @ToString.Exclude
    ActionnaireEntity actionnaire;

    boolean inBourse;
    String refEntreprise;

    BigDecimal prix;
}
