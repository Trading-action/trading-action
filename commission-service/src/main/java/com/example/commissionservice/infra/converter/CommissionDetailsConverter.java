package com.example.commissionservice.infra.converter;

import com.example.commissionservice.domain.pojo.CommissionDetail;
import com.example.commissionservice.domain.pojo.TypeCommission;
import com.example.commissionservice.infra.entity.CommissionDetailEntity;
import com.example.commissionservice.infra.entity.TypeCommissionEntity;
import com.example.commissionservice.infra.utils.Converter;


import java.util.function.Function;

public class CommissionDetailsConverter extends Converter<CommissionDetail, CommissionDetailEntity> {
    public CommissionDetailsConverter() {
        super(CommissionDetailsConverter::convertToEntity, CommissionDetailsConverter::convertToPojo);
    }

    private static CommissionDetail convertToPojo(CommissionDetailEntity commissionDetailEntity) {
        TypeCommissionConverter typeCommissionConverter = new TypeCommissionConverter();
        if (commissionDetailEntity != null){
            TypeCommission typeCommission = typeCommissionConverter.convertFromEntity(commissionDetailEntity.getTypeCommissionEntity());
            return new CommissionDetail(commissionDetailEntity.getId(), commissionDetailEntity.getRef(), commissionDetailEntity.getCreatedAt(), commissionDetailEntity.getUpdatedAt(), commissionDetailEntity.getPrice(), typeCommission);
        }
        return null;
    }

    private static CommissionDetailEntity convertToEntity(CommissionDetail commissionDetail) {
        TypeCommissionConverter typeCommissionConverter = new TypeCommissionConverter();
        TypeCommissionEntity typeCommissionEntity = typeCommissionConverter.convertFromPojos(commissionDetail.getTypeCommission());
        return new CommissionDetailEntity(commissionDetail.getId(), commissionDetail.getRef(), commissionDetail.getCreatedAt(), commissionDetail.getUpdatedAt(), typeCommissionEntity, commissionDetail.getPrice());
    }

}
