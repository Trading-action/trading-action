package com.example.commissionservice.infra.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import java.time.Instant;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class TypeCommissionEntity extends AbstractEntity {
    String label;
    Instant applicationDateMin;
    Instant applicationDateMax;
    String refTypeCompte;
    Float percentage;
    boolean tva;
    TransactionType operationType;
}
