package com.trading.action.clientservice.infra.entity;


import com.trading.action.clientservice.domain.pojo.Actionnaire;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.Instant;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ActionEntity extends AbstractEntity{

    @ManyToOne
    ActionnaireEntity actionnaire;
    boolean inBourse;
    String refEntreprise;
}
