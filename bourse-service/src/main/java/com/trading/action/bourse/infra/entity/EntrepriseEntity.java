package com.trading.action.bourse.infra.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EntrepriseEntity extends AbstractEntity {
    String libelle;
    String adress;
    BigDecimal prixAction;
    BigDecimal nombreAction;
    BigDecimal dividende;
}