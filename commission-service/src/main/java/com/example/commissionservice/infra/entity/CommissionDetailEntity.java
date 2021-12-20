package com.example.commissionservice.infra.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class CommissionDetailEntity extends AbstractEntity {
    @OneToOne
    TypeCommissionEntity typeCommission;
    BigDecimal price;
    double minimal;
}
