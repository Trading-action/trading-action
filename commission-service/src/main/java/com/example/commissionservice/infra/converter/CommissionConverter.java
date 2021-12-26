package com.example.commissionservice.infra.converter;

import com.example.commissionservice.domain.pojo.Action;
import com.example.commissionservice.domain.pojo.Commission;
import com.example.commissionservice.domain.pojo.CommissionDetail;
import com.example.commissionservice.infra.entity.CommissionDetailEntity;
import com.example.commissionservice.infra.entity.CommissionEntity;
import com.example.commissionservice.infra.utils.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommissionConverter extends Converter<Commission, CommissionEntity> {
    public CommissionConverter() {
        super(CommissionConverter::convertToEntity, CommissionConverter::convertToPojo);
    }

    private static Commission convertToPojo(CommissionEntity commissionEntity) {
        Converter<CommissionDetail, CommissionDetailEntity> commissionDetailEntityCommissionConverter = new CommissionDetailsConverter();
        List<CommissionDetail> commissionDetails = commissionDetailEntityCommissionConverter.createFromEntities(commissionEntity.getCommissionDetails());
        Action action = new Action(commissionEntity.getRefAction());
        return new Commission(commissionEntity.getId(), commissionEntity.getRef(), commissionEntity.getTotalPrice(), action, commissionEntity.getCreatedAt(), commissionEntity.getUpdatedAt(), commissionEntity.getDateCommission(), commissionDetails);
    }

    private static CommissionEntity convertToEntity(Commission commission) {
        Converter<CommissionDetail, CommissionDetailEntity> commissionDetailEntityCommissionConverter = new CommissionDetailsConverter();
        List<CommissionDetailEntity> commissionDetailEntities = commissionDetailEntityCommissionConverter.createFromPojos(commission.getCommissionDetails());
        return new CommissionEntity(commission.getId(), commission.getRef(), commission.getCreatedAt(), commission.getUpdatedAt(), commission.getAction().getRef(), commission.getDateCommission(), commissionDetailEntities, commission.getTotalPrice());
    }
}
