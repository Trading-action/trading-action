package com.example.commissionservice.infra.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import java.math.BigDecimal;
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
    BigDecimal minimal;
    String operationType;

    public TypeCommissionEntity(Long id, String ref, Instant createdAt, Instant updatedAt, String label, Instant applicationDateMin, Instant applicationDateMax, String refTypeCompte, Float percentage, boolean tva, BigDecimal minimal, String operationType) {
        super(id, ref, createdAt, updatedAt);
        this.label = label;
        this.applicationDateMin = applicationDateMin;
        this.applicationDateMax = applicationDateMax;
        this.refTypeCompte = refTypeCompte;
        this.percentage = percentage;
        this.tva = tva;
        this.minimal = minimal;
        this.operationType = operationType;
    }
}
