package com.irisi.trading.infra.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDetail extends AbstractEntity{

    double qte;
    BigDecimal prix;
    @ManyToOne
    TransactionEntity transaction;
    @ManyToOne
    IntermediareEntity intermediare;


    @ManyToOne
    ActionnaireEntity vendeur;


}
