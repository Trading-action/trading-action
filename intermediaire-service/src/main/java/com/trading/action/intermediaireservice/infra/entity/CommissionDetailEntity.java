package com.irisi.trading.infra.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class CommissionDetailEntity extends AbstractEntity {

    String libelle;
    double pourcentage;
    boolean tva;
    double minimal;
}
