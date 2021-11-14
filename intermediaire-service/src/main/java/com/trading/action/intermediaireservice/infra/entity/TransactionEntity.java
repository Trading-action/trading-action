package com.irisi.trading.infra.entity;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity extends AbstractEntity{

    TransactionType typeTransaction;
    TransactionEtat etatTransaction;

    @ManyToOne
    CommissionEntity commission;
    @OneToMany(mappedBy = "transaction")
    List<TransactionDetail> transactionDetails;
    @ManyToOne
    ActionnaireEntity acheteur;

    BigDecimal prixTotal;

    @Temporal(TemporalType.DATE)
    Date dateTransaction;

}
