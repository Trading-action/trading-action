package com.irisi.trading.infra.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommissionEntity extends AbstractEntity {
    @OneToMany(mappedBy = "commission")
    List<CommissionDetailEntity> commissionDetails;
    @ManyToOne
    CommissionIntermediareEntity commissionIntermediare;

}
