package com.trading.clientservice.infra.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActionnaireEntity extends AbstractEntity {

    @Column(unique = true)
    String username;

    @OneToOne
    CompteEntity compteEntity;


}
