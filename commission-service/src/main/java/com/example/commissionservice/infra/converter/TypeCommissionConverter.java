package com.example.commissionservice.infra.converter;

import com.example.commissionservice.domain.pojo.CompteType;
import com.example.commissionservice.domain.pojo.TypeCommission;
import com.example.commissionservice.infra.entity.TypeCommissionEntity;
import com.example.commissionservice.infra.utils.Converter;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.function.Function;

@Component
public class TypeCommissionConverter extends Converter<TypeCommission, TypeCommissionEntity> {
    public TypeCommissionConverter() {
        super(TypeCommissionConverter::convertToEntity, TypeCommissionConverter::convertToPojo);
    }

    private static TypeCommission convertToPojo(TypeCommissionEntity typeCommissionEntity) {
        CompteType compteType = new CompteType(typeCommissionEntity.getRefTypeCompte());
        return new TypeCommission(typeCommissionEntity.getId(), typeCommissionEntity.getRef(), typeCommissionEntity.getCreatedAt(), typeCommissionEntity.getUpdatedAt(), typeCommissionEntity.getLabel(), typeCommissionEntity.getApplicationDateMin(), typeCommissionEntity.getApplicationDateMax(), compteType, typeCommissionEntity.getPercentage(), typeCommissionEntity.isTva(), typeCommissionEntity.getMinimal(), typeCommissionEntity.getOperationType());
    }

    private static TypeCommissionEntity convertToEntity(TypeCommission typeCommission) {
        return new TypeCommissionEntity(typeCommission.getId(), typeCommission.getRef(), typeCommission.getCreatedAt(), typeCommission.getUpdatedAt(), typeCommission.getLabel(), typeCommission.getApplicationDateMin(), typeCommission.getApplicationDateMax(), typeCommission.getTypeCompte().getRef(), typeCommission.getPercentage(), typeCommission.isTva(), typeCommission.getMinimal(), typeCommission.getOperationType());
    }
}
