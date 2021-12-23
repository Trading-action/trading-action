package com.example.commissionservice.infra.entity;

import com.example.commissionservice.domain.pojo.CommissionIntermediare;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data // Getters + Setters + object Hash
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class CommissionEntity extends AbstractEntity {
    String refAction;

    /**
     * Date of the Commission (it may be equal to the demand date)
     **/
    Instant dateCommission;
    @OneToMany
    List<CommissionDetailEntity> commissionDetails;
    BigDecimal totalPrice;
    // private CommissionIntermediare commissionIntermediare;
}
