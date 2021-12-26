package com.example.commissionservice.infra.entity;


import com.example.commissionservice.domain.pojo.Commission;
import com.example.commissionservice.domain.pojo.TypeCommission;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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
    TypeCommissionEntity typeCommissionEntity;
    BigDecimal price;
    @ManyToOne
    CommissionEntity commissionEntity;

    public CommissionDetailEntity(Long id, String ref, Instant createdAt, Instant updatedAt, TypeCommissionEntity typeCommissionEntity, BigDecimal price) {
        super(id, ref, createdAt, updatedAt);
        this.typeCommissionEntity = typeCommissionEntity;
        this.price = price;
    }

}
