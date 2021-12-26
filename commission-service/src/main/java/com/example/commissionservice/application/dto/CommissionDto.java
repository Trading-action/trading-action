package com.example.commissionservice.application.dto;

import com.example.commissionservice.domain.commission.create.CommissionCreateInput;
import com.example.commissionservice.domain.pojo.Action;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommissionDto {
    Long id;
    String ref;
    Instant createdAt;
    Instant updatedAt;
    String refAction;
    Instant dateCommission;
    BigDecimal totalPrice;
    List<CommissionDetailDto> commissionDetails;

    public static CommissionCreateInput toCommissionCreateInput(CommissionDto commissionDto) {
        CommissionCreateInput commissionCreateInput = new CommissionCreateInput();
        commissionCreateInput.setRef(commissionDto.getRef());
        commissionCreateInput.setRefAction(commissionDto.getRefAction());
        commissionCreateInput.setDateCommission(commissionDto.getDateCommission());
        commissionCreateInput.setTotalPrice(commissionDto.getTotalPrice());
        return commissionCreateInput;
    }
}
