package com.example.commissionservice.infra.entity;

import com.example.commissionservice.domain.pojo.CommissionDetail;
import com.example.commissionservice.domain.pojo.CommissionIntermediare;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

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


    public CommissionEntity(Long id, String ref, Instant createdAt, Instant updatedAt, String refAction, Instant dateCommission, List<CommissionDetailEntity> commissionDetails, BigDecimal totalPrice) {
        super(id, ref, createdAt, updatedAt);
        this.refAction = refAction;
        this.dateCommission = dateCommission;
        this.commissionDetails = commissionDetails;
        this.totalPrice = totalPrice;
    }

    public CommissionEntity(AbstractEntityBuilder<?, ?> b, String refAction, Instant dateCommission, List<CommissionDetailEntity> commissionDetails, BigDecimal totalPrice) {
        super(b);
        this.refAction = refAction;
        this.dateCommission = dateCommission;
        this.commissionDetails = commissionDetails;
        this.totalPrice = totalPrice;
    }
}
