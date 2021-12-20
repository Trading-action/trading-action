package com.trading.action.bourseservice.infra.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import java.math.BigDecimal;


@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ActionEntity extends AbstractEntity {
    String usernameActionnaire;
    boolean inBourse;
    String referenceEntreprise;
    BigDecimal prix;
}
