package com.trading.clientservice.infra.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;


@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ActionEntity extends AbstractEntity{

    @ManyToOne
    @Getter(onMethod = @__( @JsonIgnore))
    @Setter
    @ToString.Exclude
    ActionnaireEntity actionnaire;

    boolean inBourse;
    String refEntreprise;

    BigDecimal prix;
}
