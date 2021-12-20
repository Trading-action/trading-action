package com.trading.action.bourseservice.infra.entity;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity extends AbstractEntity {

    TransactionType typeTransaction;
    TransactionEtat etatTransaction;
    String referenceCommission;
    @OneToMany(mappedBy = "transaction")
    List<TransactionDetail> transactionDetails;
    String referenceAcheteur;
    BigDecimal prixTotal;
    @Temporal(TemporalType.DATE)
    Date dateTransaction;

}
