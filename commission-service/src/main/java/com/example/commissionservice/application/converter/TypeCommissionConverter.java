package com.example.commissionservice.application.converter;

import com.example.commissionservice.application.dto.TypeCommissionDto;
import com.example.commissionservice.application.utils.Converter;
import com.example.commissionservice.domain.pojo.CompteType;
import com.example.commissionservice.domain.pojo.TypeCommission;

public class TypeCommissionConverter extends Converter<TypeCommission, TypeCommissionDto> {
    public TypeCommissionConverter() {
        super(TypeCommissionConverter::convertToDto, TypeCommissionConverter::convertToPojo);
    }

    private static TypeCommission convertToPojo(TypeCommissionDto typeCommissionDto){
        CompteType compteType = new CompteType(typeCommissionDto.getRefCompteType());
        return new TypeCommission(typeCommissionDto.getId(), typeCommissionDto.getRef(), typeCommissionDto.getCreatedAt(), typeCommissionDto.getUpdatedAt(), typeCommissionDto.getLabel(), typeCommissionDto.getApplicationDateMin(), typeCommissionDto.getApplicationDateMax(), compteType, typeCommissionDto.getPercentage(), typeCommissionDto.isTva(), typeCommissionDto.getMinimal(), typeCommissionDto.getOperationType());
    }

    private static TypeCommissionDto convertToDto(TypeCommission typeCommission){
        return new TypeCommissionDto(typeCommission.getId(), typeCommission.getRef(), typeCommission.getCreatedAt(), typeCommission.getUpdatedAt(), typeCommission.getLabel(), typeCommission.getApplicationDateMin(), typeCommission.getApplicationDateMax(), typeCommission.getTypeCompte().getRef(), typeCommission.getPercentage(), typeCommission.isTva(), typeCommission.getMinimal(), typeCommission.getOperationType());
    }
}
