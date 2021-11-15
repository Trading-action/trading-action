package com.trading.action.clientservice.infra.entity;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActionnaireEntity extends AbstractEntity {

    @Column(unique = true)
    String username;

    @OneToMany(mappedBy = "actionnaire")
    List<ActionEntity> actions;

   // @OneToMany(mappedBy = "actionnaire")
    //List<TransactionEntity> transactions;

    @OneToOne
    CompteEntity compteEntity;


}
