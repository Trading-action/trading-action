package com.trading.clientservice.infra.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompteEntity extends AbstractEntity {

    @ManyToOne
    @Getter(onMethod = @__( @JsonIgnore))
    @Setter
    CompteTypeEntity typeCompte;
}
